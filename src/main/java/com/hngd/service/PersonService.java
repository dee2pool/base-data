package com.hngd.service;

import java.util.List;

import com.hngd.common.result.Result;
import com.hngd.common.service.CodeValidator;
import com.hngd.common.web.page.PagedData;
import com.hngd.model.Personnel;
import com.hngd.model.PersonnelInfo;

public interface PersonService extends CodeValidator{

	Result<String> addPersonnel(Personnel ps);
	
	boolean existPersonnel(String name);
	
	Integer updatePersonnelById(String id, Personnel ps);
	
	Integer deletePersonnelByids(List<String> ids);
	
	Result<PagedData<PersonnelInfo>> getPersonnelList(Integer pageNo, Integer pageSize, String name, String phone, String personnelNum, String depName);
	
	List<Personnel> getPersonnelInfoById(String id);
	
	Integer updateDepIdByPersonnelId(String depId, List<String> personIds);
}
