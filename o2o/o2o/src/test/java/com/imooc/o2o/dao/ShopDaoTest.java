package com.imooc.o2o.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Shop;

public class ShopDaoTest extends BaseTest{
	
	@Autowired
	ShopDao shopDao;
	
	@Test
	public void queryTest() {
		Shop shop = new Shop();
		shop.setShopId(25l);
		List<Shop> shoplist = shopDao.queryShopList(shop, 0, 1);
		System.out.println(shoplist.get(0).getPriority());
		System.out.println(shoplist.get(0).getArea().getPriority());
	}

}
