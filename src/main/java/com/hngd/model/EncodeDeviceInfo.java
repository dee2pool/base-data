package com.hngd.model;

import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
public class EncodeDeviceInfo {
    /**
     *null
     */
    @Size(min=0,max=20)
    private String code;

    /**
     *null
     */
    @Size(min=0,max=128)
    private String name;

    /**
     *null
     */
    @Size(min=0,max=20)
    private String orgCode;

    /**
     *null
     */
    @Size(min=0,max=3)
    private String typeCode;

    /**
     *null
     */
    private Integer channelCount;

    /**
     *null
     */
    @Size(min=0,max=48)
    private String ipAddress;

    /**
     *null
     */
    private Integer streamPort;

    /**
     *null
     */
    @Size(min=0,max=120)
    private String loginName;

    /**
     *null
     */
    @Size(min=0,max=128)
    private String loginPassword;

    /**
     *null
     */
    @Size(min=0,max=2147483647)
    private String remark;

    /**
     *null
     */
    @Size(min=0,max=512)
    private String installAddress;

    /**
     *null
     */
    private Date lastModifyTime;

    /**
     *null
     */
    @Size(min=0,max=32)
    private String vendorId;

    /**
     *null
     */
    @Size(min=0,max=256)
    private String orgName;

    /**
     *null
     */
    @Size(min=0,max=128)
    private String vendorName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public Integer getChannelCount() {
        return channelCount;
    }

    public void setChannelCount(Integer channelCount) {
        this.channelCount = channelCount;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public Integer getStreamPort() {
        return streamPort;
    }

    public void setStreamPort(Integer streamPort) {
        this.streamPort = streamPort;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getInstallAddress() {
        return installAddress;
    }

    public void setInstallAddress(String installAddress) {
        this.installAddress = installAddress == null ? null : installAddress.trim();
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId == null ? null : vendorId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName == null ? null : vendorName.trim();
    }
}