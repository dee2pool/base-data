package com.hngd.model;

import java.util.Date;

public class Personnel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.id
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.personnel_num
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String personnelNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.name
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.dep_id
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String depId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.sex
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private Short sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.card_type
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String cardType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.papers_number 
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String papersNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.data_birth
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private Date dataBirth;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.pinyin_code
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String pinyinCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.phone
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.constact_address
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String constactAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.english_name
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String englishName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.email
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.takeoffice_date
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private Date takeofficeDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.departure_date
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private Date departureDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.diploma
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String diploma;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.nation
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String nation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.user_name
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.use_pwd
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String usePwd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.remark
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_personnel.picture
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    private String picture;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.id
     *
     * @return the value of tb_personnel.id
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.id
     *
     * @param id the value for tb_personnel.id
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.personnel_num
     *
     * @return the value of tb_personnel.personnel_num
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getPersonnelNum() {
        return personnelNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.personnel_num
     *
     * @param personnelNum the value for tb_personnel.personnel_num
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setPersonnelNum(String personnelNum) {
        this.personnelNum = personnelNum == null ? null : personnelNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.name
     *
     * @return the value of tb_personnel.name
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.name
     *
     * @param name the value for tb_personnel.name
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.dep_id
     *
     * @return the value of tb_personnel.dep_id
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getDepId() {
        return depId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.dep_id
     *
     * @param depId the value for tb_personnel.dep_id
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setDepId(String depId) {
        this.depId = depId == null ? null : depId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.sex
     *
     * @return the value of tb_personnel.sex
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public Short getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.sex
     *
     * @param sex the value for tb_personnel.sex
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setSex(Short sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.card_type
     *
     * @return the value of tb_personnel.card_type
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.card_type
     *
     * @param cardType the value for tb_personnel.card_type
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.papers_number 
     *
     * @return the value of tb_personnel.papers_number 
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getPapersNumber() {
        return papersNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.papers_number 
     *
     * @param papersNumber the value for tb_personnel.papers_number 
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setPapersNumber(String papersNumber) {
        this.papersNumber = papersNumber == null ? null : papersNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.data_birth
     *
     * @return the value of tb_personnel.data_birth
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public Date getDataBirth() {
        return dataBirth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.data_birth
     *
     * @param dataBirth the value for tb_personnel.data_birth
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setDataBirth(Date dataBirth) {
        this.dataBirth = dataBirth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.pinyin_code
     *
     * @return the value of tb_personnel.pinyin_code
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getPinyinCode() {
        return pinyinCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.pinyin_code
     *
     * @param pinyinCode the value for tb_personnel.pinyin_code
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode == null ? null : pinyinCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.phone
     *
     * @return the value of tb_personnel.phone
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.phone
     *
     * @param phone the value for tb_personnel.phone
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.constact_address
     *
     * @return the value of tb_personnel.constact_address
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getConstactAddress() {
        return constactAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.constact_address
     *
     * @param constactAddress the value for tb_personnel.constact_address
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setConstactAddress(String constactAddress) {
        this.constactAddress = constactAddress == null ? null : constactAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.english_name
     *
     * @return the value of tb_personnel.english_name
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.english_name
     *
     * @param englishName the value for tb_personnel.english_name
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.email
     *
     * @return the value of tb_personnel.email
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.email
     *
     * @param email the value for tb_personnel.email
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.takeoffice_date
     *
     * @return the value of tb_personnel.takeoffice_date
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public Date getTakeofficeDate() {
        return takeofficeDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.takeoffice_date
     *
     * @param takeofficeDate the value for tb_personnel.takeoffice_date
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setTakeofficeDate(Date takeofficeDate) {
        this.takeofficeDate = takeofficeDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.departure_date
     *
     * @return the value of tb_personnel.departure_date
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.departure_date
     *
     * @param departureDate the value for tb_personnel.departure_date
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.diploma
     *
     * @return the value of tb_personnel.diploma
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getDiploma() {
        return diploma;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.diploma
     *
     * @param diploma the value for tb_personnel.diploma
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setDiploma(String diploma) {
        this.diploma = diploma == null ? null : diploma.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.nation
     *
     * @return the value of tb_personnel.nation
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getNation() {
        return nation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.nation
     *
     * @param nation the value for tb_personnel.nation
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.user_name
     *
     * @return the value of tb_personnel.user_name
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.user_name
     *
     * @param userName the value for tb_personnel.user_name
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.use_pwd
     *
     * @return the value of tb_personnel.use_pwd
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getUsePwd() {
        return usePwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.use_pwd
     *
     * @param usePwd the value for tb_personnel.use_pwd
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setUsePwd(String usePwd) {
        this.usePwd = usePwd == null ? null : usePwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.remark
     *
     * @return the value of tb_personnel.remark
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.remark
     *
     * @param remark the value for tb_personnel.remark
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_personnel.picture
     *
     * @return the value of tb_personnel.picture
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public String getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_personnel.picture
     *
     * @param picture the value for tb_personnel.picture
     *
     * @mbggenerated Thu Sep 06 14:49:39 CST 2018
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }
}