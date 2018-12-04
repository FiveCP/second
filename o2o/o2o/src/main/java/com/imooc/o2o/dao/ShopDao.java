package com.imooc.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.util.BaseMapper;

@Mapper
public interface ShopDao extends BaseMapper<Shop>{

	public List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);
	
	public int countShop(@Param("shopCondition") Shop shopCondition);


}
