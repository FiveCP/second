package com.imooc.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dao.AreaDao;
import com.imooc.o2o.dto.AreaExecution;
import com.imooc.o2o.entity.Area;

public class AreaServiceTest extends BaseTest{
	
	@Autowired
	AreaService areaService;
	
	@Test
	public void queryAreaServiceTest() {
		List<Area> list = areaService.queryArea();
		Area area = new Area();
		area.setAreaDesc("楚苑");
		area.setAreaName("楚苑");
		area.setPriority(16);
		AreaExecution e = areaService.addArea(area);
		assertEquals(0,e.getState());
	}
	
	/*@Test
	public void deleteByPrimaryTest() {
		AreaExecution e = areaService.removeArea(17l);
		assertEquals(0,e.getState());
	}*/
	
	/*@Test
	public void modifyAreaServiceTest() {
		Area area = new Area();
		area.setAreaId(12l);
		AreaExecution e = areaService.modifyArea(area);
		assertEquals(0,e.getState());
	}*/
	
	/*@Test
	public void removeListAreaServiceTest() {
		List<Long> list = new ArrayList<Long>();
		list.add(8l);
		list.add(9l);
		list.add(10l);
		list.add(12l);
		AreaExecution e = areaService.removeAreaList(list);
		assertEquals(0,e.getState());
	}*/

}
