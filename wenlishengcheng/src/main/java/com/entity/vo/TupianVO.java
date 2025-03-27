package com.entity.vo;

import com.entity.TupianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 图片
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tupian")
public class TupianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 图片名称
     */

    @TableField(value = "tupian_name")
    private String tupianName;


    /**
     * 图片编号
     */

    @TableField(value = "tupian_uuid_number")
    private String tupianUuidNumber;


    /**
     * 缩略图
     */

    @TableField(value = "tupian_photo")
    private String tupianPhoto;


    /**
     * 高清文件
     */

    @TableField(value = "tupian_file")
    private String tupianFile;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 图片类型
     */

    @TableField(value = "tupian_types")
    private Integer tupianTypes;


    /**
     * 二级类型
     */

    @TableField(value = "tupian_erji_types")
    private Integer tupianErjiTypes;


    /**
     * 图片热度
     */

    @TableField(value = "tupian_clicknum")
    private Integer tupianClicknum;


    /**
     * 图片介绍
     */

    @TableField(value = "tupian_content")
    private String tupianContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "tupian_delete")
    private Integer tupianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：图片名称
	 */
    public String getTupianName() {
        return tupianName;
    }


    /**
	 * 获取：图片名称
	 */

    public void setTupianName(String tupianName) {
        this.tupianName = tupianName;
    }
    /**
	 * 设置：图片编号
	 */
    public String getTupianUuidNumber() {
        return tupianUuidNumber;
    }


    /**
	 * 获取：图片编号
	 */

    public void setTupianUuidNumber(String tupianUuidNumber) {
        this.tupianUuidNumber = tupianUuidNumber;
    }
    /**
	 * 设置：缩略图
	 */
    public String getTupianPhoto() {
        return tupianPhoto;
    }


    /**
	 * 获取：缩略图
	 */

    public void setTupianPhoto(String tupianPhoto) {
        this.tupianPhoto = tupianPhoto;
    }
    /**
	 * 设置：高清文件
	 */
    public String getTupianFile() {
        return tupianFile;
    }


    /**
	 * 获取：高清文件
	 */

    public void setTupianFile(String tupianFile) {
        this.tupianFile = tupianFile;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：图片类型
	 */
    public Integer getTupianTypes() {
        return tupianTypes;
    }


    /**
	 * 获取：图片类型
	 */

    public void setTupianTypes(Integer tupianTypes) {
        this.tupianTypes = tupianTypes;
    }
    /**
	 * 设置：二级类型
	 */
    public Integer getTupianErjiTypes() {
        return tupianErjiTypes;
    }


    /**
	 * 获取：二级类型
	 */

    public void setTupianErjiTypes(Integer tupianErjiTypes) {
        this.tupianErjiTypes = tupianErjiTypes;
    }
    /**
	 * 设置：图片热度
	 */
    public Integer getTupianClicknum() {
        return tupianClicknum;
    }


    /**
	 * 获取：图片热度
	 */

    public void setTupianClicknum(Integer tupianClicknum) {
        this.tupianClicknum = tupianClicknum;
    }
    /**
	 * 设置：图片介绍
	 */
    public String getTupianContent() {
        return tupianContent;
    }


    /**
	 * 获取：图片介绍
	 */

    public void setTupianContent(String tupianContent) {
        this.tupianContent = tupianContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getTupianDelete() {
        return tupianDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setTupianDelete(Integer tupianDelete) {
        this.tupianDelete = tupianDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
