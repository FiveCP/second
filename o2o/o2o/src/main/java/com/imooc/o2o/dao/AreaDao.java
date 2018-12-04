package com.imooc.o2o.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;


import com.imooc.o2o.entity.Area;
import com.imooc.o2o.util.BaseMapper;

@Mapper
public interface AreaDao extends BaseMapper<Area>{
	
	public List<Area> queryArea();
	
	//Area selectByPrimaryKey(long id); 
	
	//public List<Area> selectAll();
	
	//public int insert(Area area);
	
	public int removeAreaList(List<Long> areaIdList);
	

}
