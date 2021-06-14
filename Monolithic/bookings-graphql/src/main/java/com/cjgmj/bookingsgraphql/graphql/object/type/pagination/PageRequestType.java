package com.cjgmj.bookingsgraphql.graphql.object.type.pagination;

public class PageRequestType {

	private Integer page;
	private Integer size;
	private SortType sort;

	public Integer getPage() {
		return this.page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public SortType getSort() {
		return this.sort;
	}

	public void setSort(SortType sort) {
		this.sort = sort;
	}

}
