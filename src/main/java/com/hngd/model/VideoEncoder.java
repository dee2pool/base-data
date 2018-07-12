package com.hngd.model;

import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *视频编码设备
 */
public class VideoEncoder {
    /**
     *设备代码
     */
    @NotNull
    @Size(min=0,max=20)
    private String code;

    /**
     *设备名称
     */
    @NotNull
    @Size(min=0,max=128)
    private String name;

    /**
     *所属组织代码
     */
    @NotNull
    @Size(min=0,max=20)
    private String orgCode;

    /**
     *设备类型代码
     */
    @NotNull
    @Size(min=0,max=3)
    private String typeCode;

    /**
     *设备通道数
     */
    @NotNull
    private Integer channelCount;

    /**
     *设备ip地址
     */
    @NotNull
    @Size(min=0,max=48)
    private String ipAddress;

    /**
     *设备取流端口
     */
    @NotNull
    private Integer streamPort;

    /**
     *设备登录账号名称
     */
    @NotNull
    @Size(min=0,max=120)
    private String loginName;

    /**
     *设备登录账号密码
     */
    @NotNull
    @Size(min=0,max=128)
    private String loginPassword;

    /**
     *设备备注信息
     */
    @Size(min=0,max=2147483647)
    private String remark;

    /**
     *设备信息最后修改时间
     */
    @NotNull
    private Date lastModifyTime;

    /**
     *厂商Id
     */
    @NotNull
    @Size(min=0,max=32)
    private String vendorId;

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
}