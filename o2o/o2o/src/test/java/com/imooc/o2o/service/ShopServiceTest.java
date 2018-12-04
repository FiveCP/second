package com.imooc.o2o.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;

public class ShopServiceTest extends BaseTest{
	
	@Autowired
	private ShopService shopService;
	
	@Test
	public void queryShopListTest() {
		Shop shop = new Shop();
		shop.setShopId(15l);
		ShopExecution se = shopService.getShopList(shop, 1, 5);
		assertEquals(1,se.getShopList().size());
		assertEquals(1,se.getCount());
	}
	
	@Test
	public void addShopTest() {
		Shop shop = new Shop();
		CommonsMultipartFile shopImg = null;
		shop.setOwnerId(8l);
		shop.setShopName("testAutoIncr");
		shop.setEnableStatus(1);
		ShopExecution se = shopService.addShop(shop, shopImg);
		assertEquals(ShopStateEnum.SUCCESS.getState(),se.getState());
	}

}
