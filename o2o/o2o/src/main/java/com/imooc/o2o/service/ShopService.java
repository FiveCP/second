package com.imooc.o2o.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;

public interface ShopService {
	
	ShopExecution getShopList(Shop shop,int pageIndex,int pageSize);
	
	Shop getShopByShopId(long shopId);
	
	ShopExecution addShop(Shop shop,CommonsMultipartFile shopImg);

}
