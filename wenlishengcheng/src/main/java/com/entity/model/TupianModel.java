package com.entity.model;

import com.entity.TupianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 图片
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TupianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 图片名称
     */
    private String tupianName;


    /**
     * 图片编号
     */
    private String tupianUuidNumber;


    /**
     * 缩略图
     */
    private String tupianPhoto;


    /**
     * 高清文件
     */
    private String tupianFile;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 图片类型
     */
    private Integer tupianTypes;


    /**
     * 二级类型
     */
    private Integer tupianErjiTypes;


    /**
     * 图片热度
     */
    private Integer tupianClicknum;


    /**
     * 图片介绍
     */
    private String tupianContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer tupianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：图片名称
	 */
    public String getTupianName() {
        return tupianName;
    }


    /**
	 * 设置：图片名称
	 */
    public void setTupianName(String tupianName) {
        this.tupianName = tupianName;
    }
    /**
	 * 获取：图片编号
	 */
    public String getTupianUuidNumber() {
        return tupianUuidNumber;
    }


    /**
	 * 设置：图片编号
	 */
    public void setTupianUuidNumber(String tupianUuidNumber) {
        this.tupianUuidNumber = tupianUuidNumber;
    }
    /**
	 * 获取：缩略图
	 */
    public String getTupianPhoto() {
        return tupianPhoto;
    }


    /**
	 * 设置：缩略图
	 */
    public void setTupianPhoto(String tupianPhoto) {
        this.tupianPhoto = tupianPhoto;
    }
    /**
	 * 获取：高清文件
	 */
    public String getTupianFile() {
        return tupianFile;
    }


    /**
	 * 设置：高清文件
	 */
    public void setTupianFile(String tupianFile) {
        this.tupianFile = tupianFile;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 设置：赞
	 */
    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 设置：踩
	 */
    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：图片类型
	 */
    public Integer getTupianTypes() {
        return tupianTypes;
    }


    /**
	 * 设置：图片类型
	 */
    public void setTupianTypes(Integer tupianTypes) {
        this.tupianTypes = tupianTypes;
    }
    /**
	 * 获取：二级类型
	 */
    public Integer getTupianErjiTypes() {
        return tupianErjiTypes;
    }


    /**
	 * 设置：二级类型
	 */
    public void setTupianErjiTypes(Integer tupianErjiTypes) {
        this.tupianErjiTypes = tupianErjiTypes;
    }
    /**
	 * 获取：图片热度
	 */
    public Integer getTupianClicknum() {
        return tupianClicknum;
    }


    /**
	 * 设置：图片热度
	 */
    public void setTupianClicknum(Integer tupianClicknum) {
        this.tupianClicknum = tupianClicknum;
    }
    /**
	 * 获取：图片介绍
	 */
    public String getTupianContent() {
        return tupianContent;
    }


    /**
	 * 设置：图片介绍
	 */
    public void setTupianContent(String tupianContent) {
        this.tupianContent = tupianContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getTupianDelete() {
        return tupianDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setTupianDelete(Integer tupianDelete) {
        this.tupianDelete = tupianDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
