package com.hngd.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *设备通道
 */
public class DeviceChannel {
    /**
     *通道id
     */
    @Size(min=0,max=32)
    private String id;

    /**
     *通道名称
     */
    @NotNull
    @Size(min=0,max=100)
    private String name;

    /**
     *通道序号
     */
    @NotNull
    private Short orderNo;

    /**
     *关联下级设备代码
     */
    @Size(min=0,max=20)
    private String associatedDeviceCode;

    /**
     *所属设备代码
     */
    @NotNull
    @Size(min=0,max=20)
    private String parentDeviceCode;

    /**
     *备注信息
     */
    @Size(min=0,max=2147483647)
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Short orderNo) {
        this.orderNo = orderNo;
    }

    public String getAssociatedDeviceCode() {
        return associatedDeviceCode;
    }

    public void setAssociatedDeviceCode(String associatedDeviceCode) {
        this.associatedDeviceCode = associatedDeviceCode == null ? null : associatedDeviceCode.trim();
    }

    public String getParentDeviceCode() {
        return parentDeviceCode;
    }

    public void setParentDeviceCode(String parentDeviceCode) {
        this.parentDeviceCode = parentDeviceCode == null ? null : parentDeviceCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}