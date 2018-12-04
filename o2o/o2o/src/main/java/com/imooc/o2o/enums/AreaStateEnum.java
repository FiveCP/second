package com.imooc.o2o.enums;

public enum AreaStateEnum {
	OFFLINE(-1,"非法区域"),SUCCESS(0,"成功"),INNER_ERROR(-1001,"插入失败"),EMPTY(1002,"区域为空");
	
	private int state;
	private String stateInfo;
	
	private AreaStateEnum(int state,String stateInfo){
		this.state = state;
		this.stateInfo = stateInfo;
	}
	
	public int getState() {
		return state;
	}
	
	public String getStateInfo() {
		return stateInfo;
	}
	
	public static AreaStateEnum stateOf(int state) {
		for(AreaStateEnum value : values()) {
			if(value.getState() == state) {
				return value;
			}
		}
		return null;
	}

}
