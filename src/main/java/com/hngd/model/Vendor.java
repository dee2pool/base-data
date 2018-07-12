package com.hngd.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *厂商
 */
public class Vendor {
    /**
     *厂商Id
     */
    @Size(min=0,max=32)
    private String id;

    /**
     *厂商名称
     */
    @NotNull
    @Size(min=0,max=128)
    private String name;

    /**
     *厂商备注
     */
    @Size(min=0,max=2147483647)
    private String remark;

    /**
     *联系方式
     */
    @Size(min=0,max=128)
    private String contact;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }
}