package com.zkjl.wf_clserver.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/** 用户实体类 */
public class PersonnelInfo {
	private String id; // 主键
	private String idCard; // 身份证号
	private String avatar; // 头像
	private String usedName; // 曾用名
	private String name; // 姓名
	private String phone; // 电话
	private String email; // 邮箱
	private String sex; //性别
	private String nation;//民族
	private String education;//文化程度
	private String nativePlace;//籍贯
	private Date birthDate;//出生日期
	private String politicalOutlook;//政治面貌
	private String achievement;//主要成就
	private String faith;//信仰
	private String initialAddress;//初领身份证地址
	private String residenceAddress;//住所详细地址
	private String maritalStatus;//婚姻状况
	private String workplace;//工作单位
	private String tag;//人员标签
	private String localPolice;//户籍所在地派出所
	
	public PersonnelInfo() {
	}
	
	public PersonnelInfo(String id) {
		super();
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

	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * @return the usedName
	 */
	public String getUsedName() {
		return usedName;
	}

	/**
	 * @param usedName the usedName to set
	 */
	public void setUsedName(String usedName) {
		this.usedName = usedName;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the nation
	 */
	public String getNation() {
		return nation;
	}

	/**
	 * @param nation the nation to set
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}

	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * @return the nativePlace
	 */
	public String getNativePlace() {
		return nativePlace;
	}

	/**
	 * @param nativePlace the nativePlace to set
	 */
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	/**
	 * @return the birthDate
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the politicalOutlook
	 */
	public String getPoliticalOutlook() {
		return politicalOutlook;
	}

	/**
	 * @param politicalOutlook the politicalOutlook to set
	 */
	public void setPoliticalOutlook(String politicalOutlook) {
		this.politicalOutlook = politicalOutlook;
	}

	/**
	 * @return the achievement
	 */
	public String getAchievement() {
		return achievement;
	}

	/**
	 * @param achievement the achievement to set
	 */
	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	/**
	 * @return the faith
	 */
	public String getFaith() {
		return faith;
	}

	/**
	 * @param faith the faith to set
	 */
	public void setFaith(String faith) {
		this.faith = faith;
	}

	/**
	 * @return the initialAddress
	 */
	public String getInitialAddress() {
		return initialAddress;
	}

	/**
	 * @param initialAddress the initialAddress to set
	 */
	public void setInitialAddress(String initialAddress) {
		this.initialAddress = initialAddress;
	}

	/**
	 * @return the residenceAddress
	 */
	public String getResidenceAddress() {
		return residenceAddress;
	}

	/**
	 * @param residenceAddress the residenceAddress to set
	 */
	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	/**
	 * @return the maritalStatus
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @return the workplace
	 */
	public String getWorkplace() {
		return workplace;
	}

	/**
	 * @param workplace the workplace to set
	 */
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @return the local_police
	 */
	public String getLocalPolice() {
		return localPolice;
	}

	/**
	 * @param local_police the local_police to set
	 */
	public void setLocalPolice(String localPolice) {
		this.localPolice = localPolice;
	}


	
}
