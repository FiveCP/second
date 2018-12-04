package com.imooc.o2o.service;

import java.util.List;

import com.imooc.o2o.dto.AreaExecution;
import com.imooc.o2o.entity.Area;

public interface AreaService {
	
	public List<Area> queryArea();
	
	public AreaExecution addArea(Area area);
	
	public AreaExecution removeArea(long areaId);
	
	public AreaExecution modifyArea(Area area);
	
	public AreaExecution removeAreaList(List<Long> areaIdList);
	

}
