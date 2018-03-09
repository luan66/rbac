package com._520it.rbac.page;

import java.util.Collections;
import java.util.List;

import lombok.Getter;

/**
 * ��ѯ�����:
 * @author mm
 */
@Getter
public class PageResult {
	
	//��û�в�ѯ���
	public static final PageResult PAGE_RESULT= new PageResult(1, 3, Collections.EMPTY_LIST, 0);
	
	//�û�-----------
	private int currentPage;
	private int pageSize;
	//��ѯ-----------
	private List<?> list;
	private int totalCount;
	//����-----------
	private int prevPage;
	private int nextPage;
	private int totalPage;

	//��ѯ�н��:
	public PageResult(int currentPage, int pageSize, List<?> list, int totalCount) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.list = list;
		this.totalCount = totalCount;
		//����:
		this.totalPage = totalCount % pageSize == 0 ? totalCount % pageSize : totalCount % pageSize+1;
		this.prevPage = currentPage -1 > 0 ? currentPage -1 : 1;
		this.nextPage = currentPage + 1 > totalPage ? totalPage : currentPage + 1;
	}
	
}
