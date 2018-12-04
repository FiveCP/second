package com.imooc.o2o.web.superadmin;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.imooc.o2o.dto.AreaExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.enums.AreaStateEnum;
import com.imooc.o2o.service.AreaService;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	@GetMapping("/listarea")
	@ResponseBody
	private Map<String,Object> areaList() {
		Map<String,Object> modelMap = new HashMap<>();
		List<Area> list = new ArrayList<>();
		try {
			list = areaService.queryArea();
			modelMap.put("rows", list);
			modelMap.put("total", list.size());
		}catch(Exception e){
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		return modelMap;
	}
	
	@PostMapping("/addarea")
	@ResponseBody
	private Map<String,Object> addArea(HttpServletRequest hq,@RequestBody Area area){
		Map<String,Object> hm = new HashMap<String,Object>();
		try {
		area.setAreaName((area.getAreaName() == null) ? null : URLDecoder
				.decode(area.getAreaName(), "UTF-8"));
		area.setAreaDesc((area.getAreaDesc() == null) ? null : (URLDecoder
				.decode(area.getAreaDesc(), "UTF-8")));
		if(area.getPriority() == null)
			area.setPriority(0);
		}catch(Exception e) {
			hm.put("success", false);
			hm.put("errMsg", e.toString());
			return hm;
		}
		if(area != null && area.getAreaName()!=null) {
			try {
				AreaExecution ae = areaService.addArea(area);
				if(ae.getState() == AreaStateEnum.SUCCESS.getState()) {
					hm.put("success", true);
				}else {
					String s = ae.getStateInfo();
					hm.put("success", false);
					hm.put("errMsg", s);
				}
				return hm;
			}catch(Exception e) {
				hm.put("success", false);
				hm.put("errMsg", e.toString());
				return hm;
			}
		}else {
			hm.put("success", false);
			hm.put("errMsg", "请输入区域信息");
			return hm;
		}
	}
	
	@PutMapping("/modifyarea")
	@ResponseBody
	private Map<String,Object> modifyArea(HttpServletRequest hq,@RequestBody Area area){
		Map<String,Object> hm = new HashMap<String,Object>();
		try {
		area.setAreaName((area.getAreaName() == null) ? null : URLDecoder
				.decode(area.getAreaName(), "UTF-8"));
		area.setAreaDesc((area.getAreaDesc() == null) ? null : (URLDecoder
				.decode(area.getAreaDesc(), "UTF-8")));
		}catch(Exception e) {
			hm.put("success", false);
			hm.put("errMsg", e.toString());
			return hm;
		}
		if(area != null && area.getAreaId() != null && area.getAreaName() != null) {
			try {
				AreaExecution ae = areaService.modifyArea(area);
				if(ae.getState() == AreaStateEnum.SUCCESS.getState()) {
					hm.put("success", true);
				}else {
					String s = ae.getStateInfo();
					hm.put("success", false);
					hm.put("errMsg", s);
				}
				return hm;
			}catch(Exception e) {
				hm.put("success", false);
				hm.put("errMsg", e.toString());
				return hm;
			}
		}else {
			hm.put("success", false);
			hm.put("errMsg", "请输入区域信息");
			return hm;
		}
	}
	
	@DeleteMapping("/removearea")
	@ResponseBody
	private Map<String,Object> modifyArea(HttpServletRequest hq,@RequestParam Long areaId){
		Map<String,Object> hm = new HashMap<String,Object>();
		if(areaId != null && areaId.longValue()> 0) {
			try {
				AreaExecution ae = areaService.removeArea(areaId);
				if(ae.getState() == AreaStateEnum.SUCCESS.getState()) {
					hm.put("success", true);
				}else {
					String s = ae.getStateInfo();
					hm.put("success", false);
					hm.put("errMsg", s);
				}
				return hm;
			}catch(Exception e) {
				hm.put("success", false);
				hm.put("errMsg", e.toString());
				return hm;
			}
		}else {
			hm.put("success", false);
			hm.put("errMsg", "请输入区域信息");
			return hm;
		}
	}
	
	@DeleteMapping("/removeareas")
	@ResponseBody
	private Map<String,Object> modifyArea(HttpServletRequest hq,@RequestParam List<Long> areaIds){
		Map<String,Object> hm = new HashMap<String,Object>();
		if(areaIds != null && areaIds.size() > 0) {
			try {
				AreaExecution ae = areaService.removeAreaList(areaIds);
				if(ae.getState() == AreaStateEnum.SUCCESS.getState()) {
					hm.put("success", true);
				}else {
					String s = ae.getStateInfo();
					hm.put("success", false);
					hm.put("errMsg", s);
				}
				return hm;
			}catch(Exception e) {
				hm.put("success", false);
				hm.put("errMsg", e.toString());
				return hm;
			}
		}else {
			hm.put("success", false);
			hm.put("errMsg", "请输入区域信息");
			return hm;
		}
	}
	
	@GetMapping("/add")
	@ResponseBody
	public ModelAndView add(HttpServletRequest re) {
		ModelAndView mav = new ModelAndView();
		return mav;
		
	}

}
