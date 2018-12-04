package com.imooc.o2o.util;

public class pageChange {

	public static int getTotalPage(int totalCount, int pageSize) {
		int totalPage = totalCount / pageSize;
		return totalCount % pageSize == 0 ? totalPage : totalPage + 1;
	}

	public static int changeToRow(int pageIndex, int pageSize) {
		return pageIndex > 0 ? (pageIndex - 1) * pageSize : 0;
	}
}
