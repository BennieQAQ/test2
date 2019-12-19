package org.wangyu.ems.entity;

import java.util.List;

public class PageBean<T> {

	// 总记录数
	private Integer count;
	// 总页数
	private Integer totalPage;
	// 每行显示的记录数
	private Integer countPage;
	// 当前页数
	private Integer currentPage;
	// 数据
	private List<T> data;

	public PageBean() {
		super();
	}



	public PageBean(Integer count, Integer totalPage, Integer countPage, Integer currentPage, List<T> data) {
		super();
		this.count = count;
		this.totalPage = totalPage;
		this.countPage = countPage;
		this.currentPage = currentPage;
		this.data = data;
	}



	@Override
	public String toString() {
		return "PageBean [count=" + count + ", totalPage=" + totalPage + ", countPage=" + countPage + ", currentPage="
				+ currentPage + ", data=" + data + "]";
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getCountPage() {
		return countPage;
	}

	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
