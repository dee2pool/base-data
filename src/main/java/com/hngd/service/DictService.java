package com.hngd.service;

import java.util.List;

import com.hngd.common.result.Result;
import com.hngd.common.web.page.PagedData;
import com.hngd.model.Dict;
import com.hngd.model.DictDetail;
import com.hngd.model.DictDetailInfo;

public interface DictService {

	Result<String> addDict(Dict d);
	
	boolean existName(String name, String dictCode);
	
	Integer updateDict(String id, Dict d);
	
	Integer deleteDict(List<String> ids);
	
	Result<PagedData<Dict>> getDictList(Integer pageNo, Integer pageSize, String dictCode, String name);
	
	List<Dict> getChildList(String parentCode);
	
	Result<String> addDictDetail(DictDetail dd);
	
	boolean existDetailName(String name, String detailCode);
	
	Integer updateDictDetail(String id, DictDetail dd);
	
	Integer deleteDcitDetailByIds(List<String> ids);
	
	Result<PagedData<DictDetailInfo>> getDictDetailInfoList(Integer pageNo, Integer pageSize, String dictCode, String name);
	
	List<DictDetail> getDictDetailByDictCode(String dictCode);
	
	Integer updateDetailByDictCode(String dictCode, List<String> ids);
	
	List<DictDetail> getDictDetailByDetailCode(String detailCode);
}
