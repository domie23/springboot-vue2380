package com.dao;

import com.entity.TupianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TupianView;

/**
 * 图片 Dao 接口
 *
 * @author 
 */
public interface TupianDao extends BaseMapper<TupianEntity> {

   List<TupianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
