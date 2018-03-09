package com._520it.rbac.query;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QueryObject {
	private int currentPage = 1;
	private int pageSize = 3;
	
	//limit ?,?; ��һ��?��ֵ!!!
	public int getStartIndex() {
		return (currentPage-1)*pageSize;
	}
}
