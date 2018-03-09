package com._520it.rbac.page;

import java.util.Collections;
import java.util.List;

import lombok.Getter;

/**
 * 查询结果类:
 * @author mm
 */
@Getter
public class PageResult {
	
	//若没有查询结果
	public static final PageResult PAGE_RESULT= new PageResult(1, 3, Collections.EMPTY_LIST, 0);
	
	//用户-----------
	private int currentPage;
	private int pageSize;
	//查询-----------
	private List<?> list;
	private int totalCount;
	//计算-----------
	private int prevPage;
	private int nextPage;
	private int totalPage;

	//查询有结果:
	public PageResult(int currentPage, int pageSize, List<?> list, int totalCount) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.list = list;
		this.totalCount = totalCount;
		//计算:
		this.totalPage = totalCount % pageSize == 0 ? totalCount % pageSize : totalCount % pageSize+1;
		this.prevPage = currentPage -1 > 0 ? currentPage -1 : 1;
		this.nextPage = currentPage + 1 > totalPage ? totalPage : currentPage + 1;
	}
	
}
