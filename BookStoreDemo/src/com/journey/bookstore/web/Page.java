package com.journey.bookstore.web;

import java.util.List;

public class Page<T> {
	// 当前第几页
	private int pageNo;

	// 当前页的 List
	private List<T> list;

	// 每页显示多少条记录
	private int pageSize = 3;

	// 总记录数：可以用来计算总页数
	private long totalItemNumber;

	// 构造器中需要对 pageNo 进行初始化
	public Page(int pageNo) {
		super();
		this.pageNo = pageNo;
	}

	// 返回当前页的页码, 需通过 getTotalPageNumber() 进行校验
	public int getPageNo() {
		if (pageNo < 0) {
			pageNo = 1;
		}
		if (pageNo > getTotalPageNumber()) {
			pageNo = getTotalPageNumber();
		}
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public List<T> getList() {
		return list;
	}

	// 获取总页码数, 需通过 totalItemNumber 和 pageSize 计算后返回
	public int getTotalPageNumber() {
		int totalPageNumber = (int) totalItemNumber / pageSize;
		if (totalItemNumber % pageSize != 0) {
			totalPageNumber++;
		}
		return totalPageNumber;
	}

	// 设置总记录数
	public void setTotalItemNumber(long totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}

	// 上一页, 下一页相关
	// 如果有下一页
	public boolean isHasNext() {
		if (getPageNo() < getTotalPageNumber()) {
			return true;
		}
		return false;
	}

	// 如果有上一页
	public boolean isHasPrev() {
		if (getPageNo() > 1) {
			return true;
		}
		return false;
	}

	// 执行上一页
	public int getPrevPage() {
		if (isHasPrev()) {
			return getPageNo() - 1;
		}
		return getPageNo();
	}

	// 执行下一页
	public int getNextPage() {
		if (isHasNext()) {
			return getPageNo() + 1;
		}
		return getPageNo();
	}
}
