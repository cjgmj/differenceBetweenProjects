package com.cjgmj.bookingsgraphql.graphql.object.type;

import java.util.List;

import com.cjgmj.bookingsgraphql.graphql.object.type.pagination.PageRequestType;

public class UserPaged {

	private List<User> content;
	private PageRequestType pageable;
	private Integer total;

	public List<User> getContent() {
		return this.content;
	}

	public void setContent(List<User> content) {
		this.content = content;
	}

	public PageRequestType getPageable() {
		return this.pageable;
	}

	public void setPageable(PageRequestType pageable) {
		this.pageable = pageable;
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
