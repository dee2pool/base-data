package com.hngd.dao;

import com.hngd.model.Vendor;
import com.hngd.model.VendorExample;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.ibatis.annotations.Param;

public interface VendorMapper {
    long countByExample(VendorExample example);

    int deleteByExample(VendorExample example);

    int deleteByPrimaryKey(String id);

    int insert(Vendor record);

    int insertSelective(Vendor record);

    List<Vendor> selectByExample(VendorExample example);

    Vendor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Vendor record, @Param("example") VendorExample example);

    int updateByExample(@Param("record") Vendor record, @Param("example") VendorExample example);

    int updateByPrimaryKeySelective(Vendor record);

    int updateByPrimaryKey(Vendor record);
}