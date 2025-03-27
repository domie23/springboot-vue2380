package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 图片
 *
 * @author 
 * @email
 */
@TableName("tupian")
public class TupianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TupianEntity() {

	}

	public TupianEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 图片名称
     */
    @ColumnInfo(comment="图片名称",type="varchar(200)")
    @TableField(value = "tupian_name")

    private String tupianName;


    /**
     * 图片编号
     */
    @ColumnInfo(comment="图片编号",type="varchar(200)")
    @TableField(value = "tupian_uuid_number")

    private String tupianUuidNumber;


    /**
     * 缩略图
     */
    @ColumnInfo(comment="缩略图",type="varchar(200)")
    @TableField(value = "tupian_photo")

    private String tupianPhoto;


    /**
     * 高清文件
     */
    @ColumnInfo(comment="高清文件",type="varchar(200)")
    @TableField(value = "tupian_file")

    private String tupianFile;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 图片类型
     */
    @ColumnInfo(comment="图片类型",type="int(11)")
    @TableField(value = "tupian_types")

    private Integer tupianTypes;


    /**
     * 二级类型
     */
    @ColumnInfo(comment="二级类型",type="int(11)")
    @TableField(value = "tupian_erji_types")

    private Integer tupianErjiTypes;


    /**
     * 图片热度
     */
    @ColumnInfo(comment="图片热度",type="int(11)")
    @TableField(value = "tupian_clicknum")

    private Integer tupianClicknum;


    /**
     * 图片介绍
     */
    @ColumnInfo(comment="图片介绍",type="longtext")
    @TableField(value = "tupian_content")

    private String tupianContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "tupian_delete")

    private Integer tupianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Tupian{" +
            ", id=" + id +
            ", tupianName=" + tupianName +
            ", tupianUuidNumber=" + tupianUuidNumber +
            ", tupianPhoto=" + tupianPhoto +
            ", tupianFile=" + tupianFile +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", tupianTypes=" + tupianTypes +
            ", tupianErjiTypes=" + tupianErjiTypes +
            ", tupianClicknum=" + tupianClicknum +
            ", tupianContent=" + tupianContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", tupianDelete=" + tupianDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
