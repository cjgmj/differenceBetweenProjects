package com.cjgmj.bookingsgraphql.graphql.object.type.pagination;

import java.util.List;

public class SortType {

	private List<OrderType> orders;

	public List<OrderType> getOrders() {
		return this.orders;
	}

	public void setOrders(List<OrderType> orders) {
		this.orders = orders;
	}

}
