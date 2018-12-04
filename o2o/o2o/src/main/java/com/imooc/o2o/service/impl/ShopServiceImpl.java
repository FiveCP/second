package com.imooc.o2o.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.o2o.dao.ShopAuthMapDao;
import com.imooc.o2o.dao.ShopCategoryDao;
import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.pageChange;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	ShopDao shopDao;
	
	@Autowired
	ShopCategoryDao shopCategoryDao;
	
	@Autowired
	ShopAuthMapDao shopAuthMapDao;

	@Override
	public ShopExecution getShopList(Shop shop, int pageIndex, int pageSize) {
		ShopExecution shopExecution = new ShopExecution();
		int rowIndex = pageChange.changeToRow(pageIndex, pageSize);
		List<Shop> list = shopDao.queryShopList(shop, rowIndex, pageSize);
		int count = shopDao.countShop(shop);
		if (list != null && list.size() > 0) {
			shopExecution.setShopList(list);
			shopExecution.setCount(count);
			shopExecution.setState(ShopStateEnum.SUCCESS.getState());
			return shopExecution;
		} else {
			shopExecution.setState(ShopStateEnum.INNER_ERROR.getState());
			shopExecution.setStateInfo(ShopStateEnum.INNER_ERROR.getStateInfo());
			return shopExecution;
		}
	}

	@Override
	public Shop getShopByShopId(long shopId) {
		Shop shop = shopDao.selectByPrimaryKey(shopId);
		if (shop != null) {
			return shop;
		} else {
			throw new RuntimeException("请输入正确的shopId");
		}
	}

	@Transactional
	@Override
	public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) {
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
		}
		try {
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			if(shop.getShopCategory()!=null) {
				Long shopCategoryId = shop.getShopCategory().getShopCategoryId();
				ShopCategory shopCategory = shopCategoryDao.selectByPrimaryKey(shopCategoryId);
				ShopCategory parentCategory = new ShopCategory();
				parentCategory.setShopCategoryId(shopCategory.getParentId());
				shop.setParentCategory(parentCategory);
			}
			int num = shopDao.insert(shop);
			if (num <= 0) {
				throw new RuntimeException("创建店铺失败");
			} else {
				
			}
				
		} catch (Exception e) {
			throw new RuntimeException("insertShop error: " + e.getMessage());
		}
		return null;
	}

}
