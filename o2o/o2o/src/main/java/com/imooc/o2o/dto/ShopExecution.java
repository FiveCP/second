package com.imooc.o2o.dto;

import java.util.List;

import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ShopExecution {
	int state;
	String stateInfo;
	int count;
	Shop shop;
	List<Shop> shopList;

	public ShopExecution() {
	}

	public ShopExecution(ShopStateEnum se) {
		this.state = se.getState();
		this.stateInfo = se.getStateInfo();
	}

	public ShopExecution(ShopStateEnum se, Shop shop) {
		this.state = se.getState();
		this.stateInfo = se.getStateInfo();
		this.shop = shop;
	}

	public ShopExecution(ShopStateEnum se, List<Shop> shopList) {
		this.state = se.getState();
		this.stateInfo = se.getStateInfo();
		this.shopList = shopList;
	}

}
