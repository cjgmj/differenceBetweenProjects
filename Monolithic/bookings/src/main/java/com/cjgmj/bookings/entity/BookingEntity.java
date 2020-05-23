package com.cjgmj.bookings.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity(name = "Booking")
@Table(name = "bookings")
public class BookingEntity implements Serializable {

	private static final long serialVersionUID = 3038325824781116868L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private UserEntity user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room")
	private RoomEntity room;

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
		super();
	}

	public BookingEntity(Long id, UserEntity user, RoomEntity room, LocalDateTime date, String reason, Boolean accepted,
			LocalDateTime booking) {
		super();
		this.id = id;
		this.user = user;
		this.room = room;
		this.date = date;
		this.reason = reason;
		this.accepted = accepted;
		this.booking = booking;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public RoomEntity getRoom() {
		return room;
	}

	public void setRoom(RoomEntity room) {
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
