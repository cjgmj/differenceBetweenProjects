package com.cjgmj.bookingsgraphql.graphql.object.type;

import java.time.LocalDateTime;

public class Booking {

	private Integer id;
	private Integer userId;
	private Integer roomId;
	private LocalDateTime date;
	private String reason;
	private Boolean accepted;
	private LocalDateTime booking;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Boolean getAccepted() {
		return this.accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public LocalDateTime getBooking() {
		return this.booking;
	}

	public void setBooking(LocalDateTime booking) {
		this.booking = booking;
	}

}
