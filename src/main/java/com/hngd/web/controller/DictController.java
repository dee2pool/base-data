package com.hngd.web.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.hngd.common.error.ErrorCode;
import com.hngd.common.result.Result;
import com.hngd.common.web.RestResponses;
import com.hngd.common.web.page.PagedData;
import com.hngd.common.web.parameter.GsonEditor;
import com.hngd.common.web.result.RestResponse;
import com.hngd.model.Dict;
import com.hngd.model.DictDetail;
import com.hngd.model.DictDetailInfo;
import com.hngd.service.DictService;

@RestController
@RequestMapping("/dict")
public class DictController {

	private static final Logger logger = LoggerFactory.getLogger(DictController.class);
	
	@Autowired
	private DictService service;
	
	@InitBinder
	public void onBinderInit(WebDataBinder binder) {
		binder.registerCustomEditor(Dict.class, new GsonEditor(Dict.class));
		binder.registerCustomEditor(DictDetail.class, new GsonEditor(DictDetail.class));
	}
	
	/**
	 * 添加字典信息
	 * @param dict
	 * @return
	 */
	@ResponseBody
	@PostMapping("/dict/add")
	public RestResponse<String> addDict(@RequestBody @RequestParam("dict") Dict dict){
		Result<String> result = service.addDict(dict);
		if(result.isSuccess()) {
			return RestResponses.newSuccessResponse("添加字典信息成功", 1, result.getData());
		}else {
			return RestResponses.newFailResponse(result.getErrorCode(), result.getDescription());
		}
	}
	
	/**
	 * 判断字典信息的名称及code是否存在
	 * @param name
	 * @param dictCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/dict/exist", method = RequestMethod.GET)
	public RestResponse<Boolean> existName(@RequestParam("name") String name, @RequestParam("dictCode") String dictCode){
		boolean result = service.existName(name, dictCode);
		if(result) {
			return RestResponses.newSuccessResponse("不存在", 1, result);
		}else {
			return RestResponses.newSuccessResponse("不存在", 1, result);
		}
	}
	
	/**
	 * 根据id修改字典信息
	 * @param dict
	 * @param id
	 * @return
	 */
	@ResponseBody
	@PostMapping("/dict/update")
	public RestResponse<Void> updateDict(@RequestBody @RequestParam("dict") Dict dict, @RequestParam("id") String id){
		Integer result = service.updateDict(id, dict);
		if(ErrorCode.NO_ERROR.equals(result)) {
			return RestResponses.newSuccessResponse("修改字典信息成功");
		}else {
			return RestResponses.newFailResponse(result, "修改字典信息失败");
		}
	}
	
	/**
	 * 根据id删除字典信息
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@PostMapping("/dict/delete")
	public RestResponse<Void> deleteDictByIds(@RequestParam("ids") List<String> ids){
		Integer result = service.deleteDict(ids);
		if(ErrorCode.NO_ERROR.equals(result)) {
			return RestResponses.newSuccessResponse("删除字典信息成功");
		}else {
			return RestResponses.newFailResponse(result, "删除字典信息失败");
		}
	}
	
	/**
	 * 分页查询字典信息
	 * @param pageNo
	 * @param pageSize
	 * @param dictCode
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/dict/list", method = RequestMethod.GET)
	public RestResponse<List<Dict>> getDictList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize,
			@RequestParam(value="dictCode",required=false) String dictCode, @RequestParam(value="name",required=false) String name){
		Result<PagedData<Dict>> p = service.getDictList(pageNo, pageSize, dictCode, name);
		if(p.isSuccess()) {
			List<Dict> list = p.getData().getResult();
			Long total = p.getData().getTotal();
			return RestResponses.newSuccessResponse("查询字典信息成功", list.size(), list, total);
		}else {
			return RestResponses.newFailResponse(ErrorCode.INVALID_PARAMETER, "查询字典信息失败");
		}
	}
	
	/**
	 * 根据字典code,获取该子节点信息
	 * @param dictCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{dictCode}/child")
	public RestResponse<List<Dict>> getChildList(@PathVariable("dictCode") String dictCode){
		List<Dict>  list = service.getChildList(dictCode);
		if(list != null) {
			return RestResponses.newSuccessResponse("查询子字典信息成功", list.size(), list);
		}else {
			return RestResponses.newFailResponse(ErrorCode.INVALID_PARAMETER, "查询子字典信息失败");
		}
	}
	
	/**
	 * 添加字典详情信息
	 * @param dictDetail
	 * @return
	 */
	@ResponseBody
	@PostMapping("/dictDetail/add")
	public RestResponse<String> addDictDetail(@RequestBody @RequestParam("dictDetail") DictDetail dictDetail){
		Result<String> result = service.addDictDetail(dictDetail);
		if(result.isSuccess()) {
			return RestResponses.newSuccessResponse("添加字典详情信息成功", 1, result.getData());
		}else {
			return RestResponses.newFailResponse(result.getErrorCode(), result.getDescription());
		}
	}
	
	/**
	 * 判断字典详情的名称及code是否存在
	 * @param name
	 * @param detailCode
	 * @return
	 */
	@ResponseBody
	@PostMapping("/dictDetail/exist")
	public RestResponse<Boolean> existDetailName(@RequestParam("name") String name, @RequestParam("detailCode") String detailCode){
		boolean result = service.existDetailName(name, detailCode);
		if(result) {
			return RestResponses.newSuccessResponse("不存在", 1, result);
		}else {
			return RestResponses.newSuccessResponse("不存在", 1, result);
		}
	}
	
	/**
	 * 修改字典详情信息
	 * @param dictDetail
	 * @param id
	 * @return
	 */
	@ResponseBody
	@PostMapping("/dictDetail/update")
	public RestResponse<Void> updateDictDetail(@RequestBody @RequestParam("dictDetail") DictDetail dictDetail, @RequestParam("id") String id){
		Integer result = service.updateDictDetail(id, dictDetail);
		if(ErrorCode.NO_ERROR.equals(result)) {
			return RestResponses.newSuccessResponse("修改字典详情信息成功");
		}else {
			return RestResponses.newFailResponse(result, "修改字典详情信息失败");
		}
	}
	
	/**
	 * 删除字典详情信息
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@PostMapping("/dictDetail/delete")
	public RestResponse<Void>  deleteDcitDetailByIds(@RequestParam("ids") List<String> ids){
		Integer result = service.deleteDcitDetailByIds(ids);
		if(ErrorCode.NO_ERROR.equals(result)) {
			return RestResponses.newSuccessResponse("删除字典详情信息成功");
		}else {
			return RestResponses.newFailResponse(result, "删除字典详情信息失败");
		}
	}
	
	/**
	 * 分页查询字典详情信息
	 * @param pageNo
	 * @param pageSize
	 * @param dictCode
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/dictDetail/list", method = RequestMethod.GET)
	public RestResponse<List<DictDetailInfo>> getDictDetailInfoList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize,
			@RequestParam(value="dictCode",required=false) String dictCode, @RequestParam(value="name",required=false) String name){
		Result<PagedData<DictDetailInfo>> p = service.getDictDetailInfoList(pageNo, pageSize, dictCode, name);
		if(p.isSuccess()) {
			List<DictDetailInfo> list = p.getData().getResult();
			Long  total = p.getData().getTotal();
			return RestResponses.newSuccessResponse("查询字典详情信息成功", list.size(), list, total);
		}else {
			return RestResponses.newFailResponse(ErrorCode.INVALID_PARAMETER, "查询字典详情信息失败");
		}
		
	}
	
	/**
	 * 根据字典code查询字典详细信息
	 * @param dictCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/DictDetailByDictCode", method = RequestMethod.GET)
	public RestResponse<List<DictDetail>> DictDetailByDictCode(@RequestParam("dictCode") String dictCode){
		List<DictDetail> result =service.getDictDetailByDictCode(dictCode);
		if(result != null) {
			return RestResponses.newSuccessResponse("查询成功", result.size(), result);
		}else {
			return RestResponses.newFailResponse(ErrorCode.SERVER_INTERNAL_ERROR, "查询失败");
		}
	}
	
	/**
	 * 根据字典code查询设备类型列表
	 * @param dictCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/device/typeByDictCode", method = RequestMethod.GET)
	public RestResponse<List<DictDetail>> DeviceTypeByDictCode(@RequestParam("dictCode") String dictCode){
		List<DictDetail> result =service.getDictDetailByDictCode(dictCode);
		if(result != null) {
			return RestResponses.newSuccessResponse("查询成功", result.size(), result);
		}else {
			return RestResponses.newFailResponse(ErrorCode.SERVER_INTERNAL_ERROR, "查询失败");
		}
	}
	
	/**
	 * 根据字典code查询设备大类列表
	 * @param dictCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/device/typeByparentCode", method = RequestMethod.GET)
	public RestResponse<List<Dict>> DeviceTypeByparentCode(@RequestParam("dictCode") String dictCode){
		List<Dict>  list = service.getChildList(dictCode);
		if(list != null) {
			return RestResponses.newSuccessResponse("查询成功", list.size(), list);
		}else {
			return RestResponses.newFailResponse(ErrorCode.INVALID_PARAMETER, "查询失败");
		}
	}
}
