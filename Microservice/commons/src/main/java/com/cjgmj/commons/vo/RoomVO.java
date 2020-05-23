package com.cjgmj.commons.vo;

import java.io.Serializable;

public class RoomVO implements Serializable {

	private static final long serialVersionUID = -6300094599868864192L;

	private Long id;
	private String name;
	private String number;
	private String place;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
