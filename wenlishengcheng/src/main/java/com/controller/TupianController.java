
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 图片
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tupian")
public class TupianController {
    private static final Logger logger = LoggerFactory.getLogger(TupianController.class);

    private static final String TABLE_NAME = "tupian";

    @Autowired
    private TupianService tupianService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private TupianCollectionService tupianCollectionService;//图片收藏
    @Autowired
    private TupianLiuyanService tupianLiuyanService;//图片留言
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("tupianDeleteStart",1);params.put("tupianDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = tupianService.queryPage(params);

        //字典表数据转换
        List<TupianView> list =(List<TupianView>)page.getList();
        for(TupianView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TupianEntity tupian = tupianService.selectById(id);
        if(tupian !=null){
            //entity转view
            TupianView view = new TupianView();
            BeanUtils.copyProperties( tupian , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody TupianEntity tupian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tupian:{}",this.getClass().getName(),tupian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<TupianEntity> queryWrapper = new EntityWrapper<TupianEntity>()
            .eq("tupian_name", tupian.getTupianName())
            .eq("zan_number", tupian.getZanNumber())
            .eq("cai_number", tupian.getCaiNumber())
            .eq("tupian_types", tupian.getTupianTypes())
            .eq("tupian_erji_types", tupian.getTupianErjiTypes())
            .eq("shangxia_types", tupian.getShangxiaTypes())
            .eq("tupian_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TupianEntity tupianEntity = tupianService.selectOne(queryWrapper);
        if(tupianEntity==null){
            tupian.setTupianClicknum(1);
            tupian.setShangxiaTypes(1);
            tupian.setTupianDelete(1);
            tupian.setInsertTime(new Date());
            tupian.setCreateTime(new Date());
            tupianService.insert(tupian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TupianEntity tupian, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,tupian:{}",this.getClass().getName(),tupian.toString());
        TupianEntity oldTupianEntity = tupianService.selectById(tupian.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(tupian.getTupianPhoto()) || "null".equals(tupian.getTupianPhoto())){
                tupian.setTupianPhoto(null);
        }
        if("".equals(tupian.getTupianFile()) || "null".equals(tupian.getTupianFile())){
                tupian.setTupianFile(null);
        }

            tupianService.updateById(tupian);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<TupianEntity> oldTupianList =tupianService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<TupianEntity> list = new ArrayList<>();
        for(Integer id:ids){
            TupianEntity tupianEntity = new TupianEntity();
            tupianEntity.setId(id);
            tupianEntity.setTupianDelete(2);
            list.add(tupianEntity);
        }
        if(list != null && list.size() >0){
            tupianService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<TupianEntity> tupianList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            TupianEntity tupianEntity = new TupianEntity();
//                            tupianEntity.setTupianName(data.get(0));                    //图片名称 要改的
//                            tupianEntity.setTupianUuidNumber(data.get(0));                    //图片编号 要改的
//                            tupianEntity.setTupianPhoto("");//详情和图片
//                            tupianEntity.setTupianFile(data.get(0));                    //高清文件 要改的
//                            tupianEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            tupianEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            tupianEntity.setTupianTypes(Integer.valueOf(data.get(0)));   //图片类型 要改的
//                            tupianEntity.setTupianErjiTypes(Integer.valueOf(data.get(0)));   //二级类型 要改的
//                            tupianEntity.setTupianClicknum(Integer.valueOf(data.get(0)));   //图片热度 要改的
//                            tupianEntity.setTupianContent("");//详情和图片
//                            tupianEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            tupianEntity.setTupianDelete(1);//逻辑删除字段
//                            tupianEntity.setInsertTime(date);//时间
//                            tupianEntity.setCreateTime(date);//时间
                            tupianList.add(tupianEntity);


                            //把要查询是否重复的字段放入map中
                                //图片编号
                                if(seachFields.containsKey("tupianUuidNumber")){
                                    List<String> tupianUuidNumber = seachFields.get("tupianUuidNumber");
                                    tupianUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> tupianUuidNumber = new ArrayList<>();
                                    tupianUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("tupianUuidNumber",tupianUuidNumber);
                                }
                        }

                        //查询是否重复
                         //图片编号
                        List<TupianEntity> tupianEntities_tupianUuidNumber = tupianService.selectList(new EntityWrapper<TupianEntity>().in("tupian_uuid_number", seachFields.get("tupianUuidNumber")).eq("tupian_delete", 1));
                        if(tupianEntities_tupianUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TupianEntity s:tupianEntities_tupianUuidNumber){
                                repeatFields.add(s.getTupianUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [图片编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        tupianService.insertBatch(tupianList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<TupianView> returnTupianViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = tupianCollectionService.queryPage(params1);
        List<TupianCollectionView> collectionViewsList =(List<TupianCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(TupianCollectionView collectionView:collectionViewsList){
            Integer tupianTypes = collectionView.getTupianTypes();
            if(typeMap.containsKey(tupianTypes)){
                typeMap.put(tupianTypes,typeMap.get(tupianTypes)+1);
            }else{
                typeMap.put(tupianTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("tupianTypes",type);
            PageUtils pageUtils1 = tupianService.queryPage(params2);
            List<TupianView> tupianViewList =(List<TupianView>)pageUtils1.getList();
            returnTupianViewList.addAll(tupianViewList);
            if(returnTupianViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = tupianService.queryPage(params);
        if(returnTupianViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnTupianViewList.size();//要添加的数量
            List<TupianView> tupianViewList =(List<TupianView>)page.getList();
            for(TupianView tupianView:tupianViewList){
                Boolean addFlag = true;
                for(TupianView returnTupianView:returnTupianViewList){
                    if(returnTupianView.getId().intValue() ==tupianView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnTupianViewList.add(tupianView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnTupianViewList = returnTupianViewList.subList(0, limit);
        }

        for(TupianView c:returnTupianViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnTupianViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = tupianService.queryPage(params);

        //字典表数据转换
        List<TupianView> list =(List<TupianView>)page.getList();
        for(TupianView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TupianEntity tupian = tupianService.selectById(id);
            if(tupian !=null){

                //点击数量加1
                tupian.setTupianClicknum(tupian.getTupianClicknum()+1);
                tupianService.updateById(tupian);

                //entity转view
                TupianView view = new TupianView();
                BeanUtils.copyProperties( tupian , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody TupianEntity tupian, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,tupian:{}",this.getClass().getName(),tupian.toString());
        Wrapper<TupianEntity> queryWrapper = new EntityWrapper<TupianEntity>()
            .eq("tupian_name", tupian.getTupianName())
            .eq("tupian_uuid_number", tupian.getTupianUuidNumber())
            .eq("zan_number", tupian.getZanNumber())
            .eq("cai_number", tupian.getCaiNumber())
            .eq("tupian_types", tupian.getTupianTypes())
            .eq("tupian_erji_types", tupian.getTupianErjiTypes())
            .eq("tupian_clicknum", tupian.getTupianClicknum())
            .eq("shangxia_types", tupian.getShangxiaTypes())
            .eq("tupian_delete", tupian.getTupianDelete())
//            .notIn("tupian_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TupianEntity tupianEntity = tupianService.selectOne(queryWrapper);
        if(tupianEntity==null){
                tupian.setZanNumber(1);
                tupian.setCaiNumber(1);
            tupian.setTupianClicknum(1);
            tupian.setTupianDelete(1);
            tupian.setInsertTime(new Date());
            tupian.setCreateTime(new Date());
        tupianService.insert(tupian);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

