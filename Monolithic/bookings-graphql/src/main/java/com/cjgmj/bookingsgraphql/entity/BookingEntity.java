package com.cjgmj.bookingsgraphql.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity(name = "Booking")
@Table(name = "bookings")
public class BookingEntity implements Serializable {

	private static final long serialVersionUID = 3038325824781116868L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer userId;
	private Integer roomId;
	private LocalDateTime date;
	private String reason;
	private Boolean accepted;
	private LocalDateTime booking;

	@PrePersist
	public void PrePersist() {
		if (this.getAccepted() == null) {
			this.setAccepted(false);
		}

		this.setBooking(LocalDateTime.now());
	}

	public BookingEntity() {
	}

	public BookingEntity(Integer id, Integer userId, Integer roomId, LocalDateTime date, String reason,
			Boolean accepted, LocalDateTime booking) {
		this.id = id;
		this.userId = userId;
		this.roomId = roomId;
		this.date = date;
		this.reason = reason;
		this.accepted = accepted;
		this.booking = booking;
	}

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
