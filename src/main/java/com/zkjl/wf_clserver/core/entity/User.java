package com.zkjl.wf_clserver.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zkjl.wf_clserver.core.util.UuidUtils;

import java.util.Date;

/** 用户实体类 */
public class User {
	private String id; // 主键
	private String userName; // 登陆名
	private String password; // 密码
	private String newPassword; // 新密码
	private String name; // 姓名
	private String phone; // 电话
	private String email; // 邮箱
	private String role; // 角色 0 为管理员可操作其他用户
	private String photo;//头像
	private String policeNumber;//警号
	private String job;
	private String department;
	private Date createDate;
	private Date updateDate;
	private String delFlag;
	
	public User() {
		this.delFlag = "0";
	}
	
	public User(String id) {
		super();
		this.delFlag = "0";
	}
	  public void preInsert()
	  {
	     setId(UuidUtils.creatUUID());
	    this.updateDate = new Date();
	    if (this.createDate == null)
	      this.createDate = new Date();
	  }

	  public void preUpdate()
	  {
	    this.updateDate = new Date();
	    setDefaultValue();
	  }

	  public void setDefaultValue()
	  {
	  }
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", name=" + name + ", phone=" + phone + ", email=" + email + ", role="
				+ role + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the policeNumber
	 */
	public String getPoliceNumber() {
		return policeNumber;
	}

	/**
	 * @param policeNumber the policeNumber to set
	 */
	public void setPoliceNumber(String policeNumber) {
		this.policeNumber = policeNumber;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the createDate
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the updateDate
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the delFlag
	 */
	public String getDelFlag() {
		return delFlag;
	}

	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	
}
