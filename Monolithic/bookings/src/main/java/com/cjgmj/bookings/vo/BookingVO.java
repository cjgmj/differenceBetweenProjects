package com.cjgmj.bookings.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BookingVO implements Serializable {

	private static final long serialVersionUID = 3183441835854339357L;

	private Long id;
	private UserVO user;
	private RoomVO room;
	private LocalDateTime date;
	private String reason;
	private Boolean accepted;
	private LocalDateTime booking;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public RoomVO getRoom() {
		return room;
	}

	public void setRoom(RoomVO room) {
		this.room = room;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public LocalDateTime getBooking() {
		return booking;
	}

	public void setBooking(LocalDateTime booking) {
		this.booking = booking;
	}

}
