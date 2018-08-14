/**
 * 文件名：OrgController.java
 * 时间：2015年9月24日 下午2:20:31
 * 作者：virgil
 * 备注：
 */

package com.hngd.web.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hngd.common.error.ErrorCode;
import com.hngd.common.result.Result;
import com.hngd.common.util.GsonUtils;
import com.hngd.common.web.RestResponses;
import com.hngd.common.web.auth.UserCredential;
import com.hngd.common.web.context.HttpRequestContext;
import com.hngd.common.web.page.PagedData;
import com.hngd.common.web.parameter.GsonEditor;
import com.hngd.common.web.result.RestResponse;
import com.hngd.model.Area;
import com.hngd.model.Organization;
import com.hngd.service.OrgService;

/**
 * 组织管理
 * 
 * @author tqd
 */
@RestController
@RequestMapping("/org")
public class OrgController {
	private static final Logger logger = LoggerFactory.getLogger(OrgController.class);
	@Autowired
	private OrgService orgService;

	@InitBinder
	public void onBinderInit(WebDataBinder binder){
		binder.registerCustomEditor(Organization.class, new GsonEditor(Organization.class));
	}
	/**
	 * 添加组织
	 * 
	 * @param org
	 *            待添加组织的信息
	 * @param areaCode
	 *            地区代码
	 * @return
	 * @since 0.0.1
	 * @author tqd
	 * @time 2015年9月24日 下午2:20:31
	 */
	@ResponseBody
	@PostMapping("/add")
	public RestResponse<String> addOrg(@RequestBody @RequestParam("org") Organization org,
			@RequestParam("areaCode") String areaCode) {
		Result<String> result = orgService.addOrgnization(org, areaCode);
		if (result.isSuccess()) {
			// 通知内存中的组织结构信息需要更新
			return RestResponses.newSuccessResponse("添加组织机构成功", 1, result.getData());
		} else {
			return RestResponses.newFailResponse(result.getErrorCode(), result.getDescription());
		}
	}

	/**
	 * 判断组织名称orgName是否已存在
	 * 
	 * @param orgName
	 *            组织名称
	 * @return 如果存在 ResponseEntity.data 的值为true,否则为false
	 * @author tqd
	 * @since 0.0.1
	 * @time 2015年9月24日 下午2:20:31
	 */
	@ResponseBody
	@RequestMapping(value = "/name/exist", method = RequestMethod.GET)
	public RestResponse<Boolean> existOrgName(@RequestParam("orgName") String orgName) {
		boolean result = orgService.existOrgName(orgName);
		if (result) {
			return RestResponses.newSuccessResponse("组织名已存在", 1, result);
		} else {
			return RestResponses.newSuccessResponse("组织名不存在", 1, result);
		}
	}

	/**
	 * 根据组织编码更新组织信息
	 * 
	 * @param orgCode
	 *            待修改组织的代码
	 * @param org
	 *            待修改组织的修改后的信息
	 * @return
	 * @author tqd
	 * @since 0.0.1
	 * @time 2015年9月24日 下午2:20:31
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public RestResponse<Void> updateOrg(@RequestParam("orgCode")String orgCode,
			@RequestBody @RequestParam("org") Organization org) {
		Integer result = orgService.updateOrgByCode(orgCode, org);
		if (ErrorCode.NO_ERROR.equals(result)) {
			// 通知内存中的组织结构信息需要更新
			return RestResponses.newSuccessResponse("修改组织机构信息成功");
		} else {
			return RestResponses.newFailResponse(result,"修改组织机构信息失败");
		}
	}

	/**
	 * 分页 多条件 排序查询组织信息
	 * 
	 * @param page
	 *            查询分装对象
	 * @return 如果查询成功,Response.extra字段保存的时记录总条目
	 * @author tqd
	 * @since 0.0.1
	 * @time 2015年9月24日 下午2:20:31
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RestResponse<List<Organization>> getOrgList(@RequestParam( "pageNo") Integer pageNo,
			@RequestParam( "pageSize") Integer pageSize,
			@RequestParam( value="orgName",required=false) String orgName) {
		Result<PagedData<Organization>> p = orgService.getOrgList(pageNo,pageSize,orgName);
		if (p .isSuccess()) {
		    List<Organization> list = p.getData().getResult();
			Long total = p.getData().getTotal();
		    return RestResponses.newSuccessResponse("查询组织信息成功", list.size(), list, total); 
		} else {
			return RestResponses.newFailResponse(ErrorCode.INVALID_PARAMETER,"查询组织信息失败");
		}
	}

	/**
	 * 根据组织代码,查询该组织的直接子组织节点
	 * 
	 * @param orgCode
	 *            组织代码,访问根节点请传入"-1"
	 * @return
	 * @author tqd
	 * @since 1.0.0
	 * @time 2015年11月18日 上午11:08:41
	 */
	@ResponseBody
	@RequestMapping(value = "/{orgCode}/chidlren", method = RequestMethod.GET)
	public RestResponse<List<Organization>> getChildList(@PathVariable("orgCode") String orgCode) {
		Object tag=HttpRequestContext.getRequestTag();
		UserCredential user=(UserCredential)tag;
		// 如果是获取根节点
		List<Organization> list = null;
		if ("-1".equals(orgCode)) {
			String domainCode = user.getDomainCode();
			list=orgService.getOrgbyDomainCode(domainCode);
		} else {
			list = orgService.getChildList(orgCode);
		}
		if (list != null) {
			return RestResponses.newSuccessResponse("获取直接子组织节点成功", list.size(), list);
		} else {
			return RestResponses.newFailResponse(ErrorCode.SERVER_INTERNAL_ERROR,"获取子节点失败");
		}
	}

	/**
	 * 根据组织代码删除组织,包括其所有子节点,其以及其所有子节点所含有的资源(服务,用户,设备等一切资源)
	 * 
	 * @param orgCode
	 *            组织代码
	 * @return
	 * @author tqd
	 * @since 1.0.0
	 * @time 2015年12月30日 上午9:32:58
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public RestResponse<Void> deleteOrgByCode(@RequestParam("orgCode") String orgCode) {
	    Integer result = orgService.deleteOrgByCodes(Arrays.asList(orgCode));
		if (ErrorCode.NO_ERROR.equals(result)) {
		    // 通知内存中的组织数据需要更新
		    return RestResponses.newSuccessResponse("删除组织成功");
		} else {
		    return RestResponses.newFailResponse(result,"删除组织失败");
		}
	}
 
	/**
	 * 获取当前行政地区的子行政地区
	 * 
	 * @param areaCode
	 *            当前行政地区编码，省级政地区的父编码为000000，
	 * @return
	 * @author Administrator
	 * @time 2016年6月14日 上午10:27:16
	 */
	@ResponseBody
	@RequestMapping(value = "/area/{areaCode}/children", method = RequestMethod.GET)
	public RestResponse<List<Area>> getChildArea(@PathVariable("areaCode") String areaCode) {
		List<Area> list = orgService.getChildArea(areaCode);
		if (list != null) {
			return RestResponses.newSuccessResponse("加载地区信息成功", list.size(), list);
		} else {
			return RestResponses.newFailResponse(ErrorCode.INVALID_PARAMETER,"加载地区信息失败");
		}
	}

	/**
	 * 一次查询所有组织信息
	 * 
	 * @param page
	 *            查询分装对象
	 * @return 如果查询成功,Response.extra字段保存的时记录总条目
	 * @author zcm
	 * @since 0.0.1
	 * @time 2016年9月26日 下午2:20:31
	 */
	@ResponseBody
	@RequestMapping(value = "/list/all", method = RequestMethod.GET)
	public RestResponse<List<Organization>> listAllOrg() {
	    List<Organization> list = orgService.listAllOrgs();
		if (list != null) {
			return RestResponses.newSuccessResponse("查询组织信息成功", list.size(), list);
		} else {
			return RestResponses.newFailResponse( ErrorCode.DB_ERROR,"查询组织信息失败");
		}
	
	}

	/**
	 * 查询一个组织信息
	 * 
	 * @param orgCode
	 *            查询对象code
	 * @return 如果查询成功,Response.extra字段保存的时记录总条目
	 * @author tqd
	 * @since 0.0.1
	 * @time 2016年9月26日 下午2:20:31
	 */
	@ResponseBody
	@RequestMapping(value = "/{orgCode}", method = RequestMethod.GET)
	public RestResponse<Organization> getOrgByCode(@PathVariable("orgCode") String orgCode) {
		Organization org = orgService.getOrgbyCode(orgCode);
		if (org != null) {
			return RestResponses.newSuccessResponse("查询组织信息成功", 1, org);
		} else {
			return RestResponses.newFailResponse(ErrorCode.TARGET_NOT_FOUND,"查询组织信息失败");
		}

	}
}
