package com.cjgmj.booking.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjgmj.booking.service.IBookingService;
import com.cjgmj.commons.vo.BookingVO;

@RestController
@RequestMapping
public class BookingController {

	@Autowired
	private IBookingService bookingService;

	@PostMapping
	public BookingVO bookingRoom(@RequestBody BookingVO booking) {
		return bookingService.bookingRoom(booking);
	}

	@GetMapping("/{id}")
	public List<BookingVO> getBookingsByRoom(@PathVariable Long id) {
		return bookingService.getBookingsByRoom(id);
	}

	@GetMapping("/between")
	public List<BookingVO> getBookingsBetween(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate from,
			@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate to) {
		return bookingService.getBookingsBetween(from, to);
	}

	@GetMapping("/user")
	public List<BookingVO> getBookingsByUser(@RequestParam String name, @RequestParam String surname) {
		return bookingService.getBookingsByUser(name, surname);
	}

	@GetMapping("/reason-null")
	public List<BookingVO> getBookingsByReasonNull() {
		return bookingService.getBookingsByReasonNull();
	}

	@GetMapping("/after/{date}")
	public List<BookingVO> getBookingsAfter(@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate date) {
		return bookingService.getBookingsAfter(date);
	}

	@GetMapping("/accepteds")
	public List<BookingVO> getBookingsAccepted() {
		return bookingService.getBookingsAccepted();
	}

}
