package com.hngd.web.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hngd.common.error.ErrorCode;
import com.hngd.common.result.Result;
import com.hngd.common.web.RestResponses;
import com.hngd.common.web.page.PagedData;
import com.hngd.common.web.parameter.GsonEditor;
import com.hngd.common.web.result.RestResponse;
import com.hngd.model.Personnel;
import com.hngd.model.PersonnelInfo;
import com.hngd.service.PersonService;

@ResponseBody
@RestController("/person")
public class PersonnelController {

	private static final Logger logger = LoggerFactory.getLogger(PersonnelController.class);
	
	@InitBinder
	public void onBinderInit(WebDataBinder binder) {
		binder.registerCustomEditor(Personnel.class, new GsonEditor(Personnel.class));
	}
	
	@Autowired
	private PersonService service;
	
	/**
	 * 添加人员信息
	 * @param ps 人员信息
	 * @return
	 */
	@PostMapping("/add")
	public RestResponse<String> addPersonnel(@RequestBody @RequestParam("ps") Personnel ps){
		Result<String> result = service.addPersonnel(ps);
		if(result.isSuccess()) {
			return RestResponses.newSuccessResponse("添加人员信息成功", 1, result.getData());
		}else {
			return RestResponses.newFailResponse(result.getErrorCode(), result.getDescription());
		}

	}
	
	/**
	 * 判断人员名称是否存在
	 * @param name 人员名称
	 * @return
	 */
	@GetMapping("/name/exist")
	public RestResponse<Boolean> existPersonnelName(@RequestParam("name") String name){
		boolean result = service.existPersonnel(name);
		return RestResponses.newSuccessResponse("", 1, result);
	}
	
	/**
	 * 根据人员ID，修改人员信息
	 * @param id 人员ID
	 * @param ps 人员信息
	 * @return
	 */
	@PostMapping("/update")
	public RestResponse<Void> updatePersonnelById(@RequestParam("id") String id,
			@RequestBody @RequestParam("ps") Personnel ps){
		Integer result = service.updatePersonnelById(id, ps);
		if(ErrorCode.NO_ERROR.equals(result)) {
			return RestResponses.newSuccessResponse("修改人员信息成功");
		}else {
			return RestResponses.newFailResponse(result, "修改人员信息失败");
		}
	}
	
	/**
	 * 根据人员id集合删除人员信息
	 * @param ids 人员集合
	 * @return
	 */
	@PostMapping("/delete")
	public RestResponse<Void> deletePersonnelByIds(@RequestBody @RequestParam("ids") List<String> ids){
		Integer result = service.deletePersonnelByids(ids);
		if(ErrorCode.NO_ERROR.equals(result)) {
			return RestResponses.newSuccessResponse("删除人员信息成功");
		}else {
			return RestResponses.newFailResponse(result, "删除人员信息失败");
		}
	}
	
	/**
	 * 分页查询人员信息
	 * @param pageNo
	 * @param pageSize
	 * @param name 人员名称
	 * @param phone 手机号码
	 * @param personnelNum 人员编号
	 * @param depName 部门名称
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RestResponse<List<PersonnelInfo>> getPersonnerlList(@RequestParam( "pageNo") Integer pageNo, @RequestParam( "pageSize") Integer pageSize, 
			@RequestParam( "name") String name, @RequestParam( "phone") String phone, @RequestParam( "personnelNum") String personnelNum,
			@RequestParam( "depName") String depName){
		Result<PagedData<PersonnelInfo>> p = service.getPersonnelList(pageNo, pageSize, name, phone, personnelNum, depName);
		if(p.isSuccess()) {
			List<PersonnelInfo> list = p.getData().getResult();
			Long total = p.getData().getTotal();
			return RestResponses.newSuccessResponse("查询人员信息成功", list.size(), list, total);
		}else {
			return RestResponses.newFailResponse(ErrorCode.INVALID_PARAMETER, "查询人员信息失败");
		}
	}
	
	/**
	 * 修改部门的人员信息
	 * @param depId 部门id
	 * @param personIds 人员id集合
	 * @return
	 */
	@PostMapping(value = "/update/depId")
	public RestResponse<Void> updateDepIdByPersonnelId(@RequestParam("depId") String depId, 
			@RequestBody @RequestParam("depId") List<String> personIds){
		Integer result = service.updateDepIdByPersonnelId(depId, personIds);
		if(ErrorCode.NO_ERROR.equals(result)) {
			return RestResponses.newSuccessResponse("修改部门成功");
		}else {
			return RestResponses.newFailResponse(result, "修改部门失败");
		}
	}
	
}
