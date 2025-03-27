package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.TupianEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 图片
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("tupian")
public class TupianView extends TupianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 图片类型的值
	*/
	@ColumnInfo(comment="图片类型的字典表值",type="varchar(200)")
	private String tupianValue;
	/**
	* 二级类型的值
	*/
	@ColumnInfo(comment="二级类型的字典表值",type="varchar(200)")
	private String tupianErjiValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;




	public TupianView() {

	}

	public TupianView(TupianEntity tupianEntity) {
		try {
			BeanUtils.copyProperties(this, tupianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 图片类型的值
	*/
	public String getTupianValue() {
		return tupianValue;
	}
	/**
	* 设置： 图片类型的值
	*/
	public void setTupianValue(String tupianValue) {
		this.tupianValue = tupianValue;
	}
	//当前表的
	/**
	* 获取： 二级类型的值
	*/
	public String getTupianErjiValue() {
		return tupianErjiValue;
	}
	/**
	* 设置： 二级类型的值
	*/
	public void setTupianErjiValue(String tupianErjiValue) {
		this.tupianErjiValue = tupianErjiValue;
	}
	//当前表的
	/**
	* 获取： 是否上架的值
	*/
	public String getShangxiaValue() {
		return shangxiaValue;
	}
	/**
	* 设置： 是否上架的值
	*/
	public void setShangxiaValue(String shangxiaValue) {
		this.shangxiaValue = shangxiaValue;
	}




	@Override
	public String toString() {
		return "TupianView{" +
			", tupianValue=" + tupianValue +
			", tupianErjiValue=" + tupianErjiValue +
			", shangxiaValue=" + shangxiaValue +
			"} " + super.toString();
	}
}
