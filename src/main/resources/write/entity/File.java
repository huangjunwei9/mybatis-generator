package com.design.framework.entity;

import com.design.framework.base.entity.BaseEntity;
import org.apache.ibatis.type.Alias;
import javax.persistence.Table;

/**
 * 文件管理
 * 
 * @author johnDeng
 * @datatime 2019-03-05 03:28:29
 */
@Alias(value = "file")
@Table(name = "t_file")
public class File extends BaseEntity<String> {

	private static final long serialVersionUID = 1L;

	/**
	 * 文件管理ID
	 */
	private String id;
	/**
	 * 机构ID
	 */
	private String orgId;
	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件链接
	 */
	private String fileUrl;
	/**
	 * 0草稿，1上架，2下架
	 */
	private Integer state;
	/**
	*
	*/
	private java.util.Date createTime;
	/**
	*
	*/
	private java.util.Date updateTime;
	/**
	*
	*/
	private Integer delFlag;
	/**
	*
	*/
	private String createId;
	/**
	*
	*/
	private String updateId;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getState() {
		return state;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getCreateId() {
		return createId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getUpdateId() {
		return updateId;
	}

}
