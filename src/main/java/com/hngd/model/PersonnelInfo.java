package com.hngd.model;

import java.util.Date;

public class PersonnelInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vw_personnel.id
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vw_personnel.personnel_num
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    private String personnelNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vw_personnel.name
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vw_personnel.dep_name
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    private String depName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vw_personnel.sex
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    private Short sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vw_personnel.card_type
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    private String cardType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vw_personnel.papers_number 
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    private String papersNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vw_personnel.data_birth
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    private Date dataBirth;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vw_personnel.phone
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    private String phone;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vw_personnel.id
     *
     * @return the value of vw_personnel.id
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vw_personnel.id
     *
     * @param id the value for vw_personnel.id
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vw_personnel.personnel_num
     *
     * @return the value of vw_personnel.personnel_num
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public String getPersonnelNum() {
        return personnelNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vw_personnel.personnel_num
     *
     * @param personnelNum the value for vw_personnel.personnel_num
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public void setPersonnelNum(String personnelNum) {
        this.personnelNum = personnelNum == null ? null : personnelNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vw_personnel.name
     *
     * @return the value of vw_personnel.name
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vw_personnel.name
     *
     * @param name the value for vw_personnel.name
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vw_personnel.dep_name
     *
     * @return the value of vw_personnel.dep_name
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public String getDepName() {
        return depName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vw_personnel.dep_name
     *
     * @param depName the value for vw_personnel.dep_name
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vw_personnel.sex
     *
     * @return the value of vw_personnel.sex
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public Short getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vw_personnel.sex
     *
     * @param sex the value for vw_personnel.sex
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public void setSex(Short sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vw_personnel.card_type
     *
     * @return the value of vw_personnel.card_type
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vw_personnel.card_type
     *
     * @param cardType the value for vw_personnel.card_type
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vw_personnel.papers_number 
     *
     * @return the value of vw_personnel.papers_number 
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public String getPapersNumber() {
        return papersNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vw_personnel.papers_number 
     *
     * @param papersNumber the value for vw_personnel.papers_number 
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public void setPapersNumber(String papersNumber) {
        this.papersNumber = papersNumber == null ? null : papersNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vw_personnel.data_birth
     *
     * @return the value of vw_personnel.data_birth
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public Date getDataBirth() {
        return dataBirth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vw_personnel.data_birth
     *
     * @param dataBirth the value for vw_personnel.data_birth
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public void setDataBirth(Date dataBirth) {
        this.dataBirth = dataBirth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vw_personnel.phone
     *
     * @return the value of vw_personnel.phone
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vw_personnel.phone
     *
     * @param phone the value for vw_personnel.phone
     *
     * @mbggenerated Thu Sep 06 15:21:50 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}