package com.cjgmj.bookingsgraphql.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Room")
@Table(name = "rooms")
public class RoomEntity implements Serializable {

	private static final long serialVersionUID = 952865104806256425L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private String number;
	private String place;

	public RoomEntity() {
		super();
	}

	public RoomEntity(Integer id, String name, String number, String place) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.place = place;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
