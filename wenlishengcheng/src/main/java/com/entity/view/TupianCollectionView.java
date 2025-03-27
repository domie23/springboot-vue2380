package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.TupianCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 图片收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("tupian_collection")
public class TupianCollectionView extends TupianCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String tupianCollectionValue;

	//级联表 图片
		/**
		* 图片名称
		*/

		@ColumnInfo(comment="图片名称",type="varchar(200)")
		private String tupianName;
		/**
		* 图片编号
		*/

		@ColumnInfo(comment="图片编号",type="varchar(200)")
		private String tupianUuidNumber;
		/**
		* 缩略图
		*/

		@ColumnInfo(comment="缩略图",type="varchar(200)")
		private String tupianPhoto;
		/**
		* 高清文件
		*/

		@ColumnInfo(comment="高清文件",type="varchar(200)")
		private String tupianFile;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 图片类型
		*/
		@ColumnInfo(comment="图片类型",type="int(11)")
		private Integer tupianTypes;
			/**
			* 图片类型的值
			*/
			@ColumnInfo(comment="图片类型的字典表值",type="varchar(200)")
			private String tupianValue;
		/**
		* 二级类型
		*/
		@ColumnInfo(comment="二级类型",type="int(11)")
		private Integer tupianErjiTypes;
			/**
			* 二级类型的值
			*/
			@ColumnInfo(comment="二级类型的字典表值",type="varchar(200)")
			private String tupianErjiValue;
		/**
		* 图片热度
		*/

		@ColumnInfo(comment="图片热度",type="int(11)")
		private Integer tupianClicknum;
		/**
		* 图片介绍
		*/

		@ColumnInfo(comment="图片介绍",type="longtext")
		private String tupianContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer tupianDelete;
	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public TupianCollectionView() {

	}

	public TupianCollectionView(TupianCollectionEntity tupianCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, tupianCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getTupianCollectionValue() {
		return tupianCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setTupianCollectionValue(String tupianCollectionValue) {
		this.tupianCollectionValue = tupianCollectionValue;
	}


	//级联表的get和set 图片

		/**
		* 获取： 图片名称
		*/
		public String getTupianName() {
			return tupianName;
		}
		/**
		* 设置： 图片名称
		*/
		public void setTupianName(String tupianName) {
			this.tupianName = tupianName;
		}

		/**
		* 获取： 图片编号
		*/
		public String getTupianUuidNumber() {
			return tupianUuidNumber;
		}
		/**
		* 设置： 图片编号
		*/
		public void setTupianUuidNumber(String tupianUuidNumber) {
			this.tupianUuidNumber = tupianUuidNumber;
		}

		/**
		* 获取： 缩略图
		*/
		public String getTupianPhoto() {
			return tupianPhoto;
		}
		/**
		* 设置： 缩略图
		*/
		public void setTupianPhoto(String tupianPhoto) {
			this.tupianPhoto = tupianPhoto;
		}

		/**
		* 获取： 高清文件
		*/
		public String getTupianFile() {
			return tupianFile;
		}
		/**
		* 设置： 高清文件
		*/
		public void setTupianFile(String tupianFile) {
			this.tupianFile = tupianFile;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 图片类型
		*/
		public Integer getTupianTypes() {
			return tupianTypes;
		}
		/**
		* 设置： 图片类型
		*/
		public void setTupianTypes(Integer tupianTypes) {
			this.tupianTypes = tupianTypes;
		}


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
		/**
		* 获取： 二级类型
		*/
		public Integer getTupianErjiTypes() {
			return tupianErjiTypes;
		}
		/**
		* 设置： 二级类型
		*/
		public void setTupianErjiTypes(Integer tupianErjiTypes) {
			this.tupianErjiTypes = tupianErjiTypes;
		}


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

		/**
		* 获取： 图片热度
		*/
		public Integer getTupianClicknum() {
			return tupianClicknum;
		}
		/**
		* 设置： 图片热度
		*/
		public void setTupianClicknum(Integer tupianClicknum) {
			this.tupianClicknum = tupianClicknum;
		}

		/**
		* 获取： 图片介绍
		*/
		public String getTupianContent() {
			return tupianContent;
		}
		/**
		* 设置： 图片介绍
		*/
		public void setTupianContent(String tupianContent) {
			this.tupianContent = tupianContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


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

		/**
		* 获取： 逻辑删除
		*/
		public Integer getTupianDelete() {
			return tupianDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setTupianDelete(Integer tupianDelete) {
			this.tupianDelete = tupianDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}


	@Override
	public String toString() {
		return "TupianCollectionView{" +
			", tupianCollectionValue=" + tupianCollectionValue +
			", tupianName=" + tupianName +
			", tupianUuidNumber=" + tupianUuidNumber +
			", tupianPhoto=" + tupianPhoto +
			", tupianFile=" + tupianFile +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", tupianClicknum=" + tupianClicknum +
			", tupianContent=" + tupianContent +
			", tupianDelete=" + tupianDelete +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
