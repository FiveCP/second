package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;

public class AreaDaoTest extends BaseTest {
	
	@Autowired
	AreaDao areaDao;
	
	@Test
	public void testQueryArea() {
		Area area1 = new Area();
		Area area2 = new Area();
		area2.setAreaId(3l);
		//areaDao.selectByPrimaryKey(area2);
		Area area = areaDao.selectByPrimaryKey(3l);
		area1.setAreaDesc("华苑");
		area1.setAreaName("华苑");
		area1.setCreateTime(new Date());
		area1.setLastEditTime(new Date());
		area1.setPriority(9);
		//areaDao.insert(area1);
		List<Area> list = areaDao.selectAll();
		assertEquals("东苑",area.getAreaDesc());
	}

}
