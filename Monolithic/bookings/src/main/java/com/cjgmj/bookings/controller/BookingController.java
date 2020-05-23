package com.cjgmj.bookings.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjgmj.bookings.service.IBookingService;
import com.cjgmj.bookings.service.IRoomService;
import com.cjgmj.bookings.service.IUserService;
import com.cjgmj.bookings.vo.BookingVO;
import com.cjgmj.bookings.vo.RoomVO;
import com.cjgmj.bookings.vo.UserVO;

@RestController
@RequestMapping
public class BookingController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoomService roomService;

	@Autowired
	private IBookingService bookingService;

	@GetMapping("/users")
	public List<UserVO> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/users/page")
	public Page<UserVO> getUsersPage(@RequestParam Integer numPage, @RequestParam Integer pageSize) {
		return userService.getUsersPage(numPage, pageSize);
	}

	@GetMapping("/users/{id}")
	public UserVO getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@GetMapping("/users/like/{text}")
	public List<UserVO> getUserLike(@PathVariable String text) {
		return userService.getUserLike(text);
	}

	@GetMapping("/users/order/name")
	public List<UserVO> getUserOrderName() {
		return userService.getUserOrderName();
	}

	@GetMapping("/users/minor/{age}")
	public List<UserVO> getUserMinor(@PathVariable Integer age) {
		return userService.getUserMinor(age);
	}

	@PostMapping("/users")
	public UserVO insertUser(@RequestBody UserVO user) {
		return userService.insertOrUpdateUser(user);
	}

	@PutMapping("/users")
	public UserVO updateUser(@RequestBody UserVO user) {
		return userService.insertOrUpdateUser(user);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

	@GetMapping("/rooms")
	public List<RoomVO> getRooms() {
		return roomService.getRooms();
	}

	@PostMapping("/bookings")
	public BookingVO bookingRoom(@RequestBody BookingVO booking) {
		return bookingService.bookingRoom(booking);
	}

	@GetMapping("/bookings/{id}")
	public List<BookingVO> getBookingsByRoom(@PathVariable Long id) {
		return bookingService.getBookingsByRoom(id);
	}

	@GetMapping("/bookings/between")
	public List<BookingVO> getBookingsBetween(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate from,
			@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate to) {
		return bookingService.getBookingsBetween(from, to);
	}

	@GetMapping("/bookings/user")
	public List<BookingVO> getBookingsByUser(@RequestParam String name, @RequestParam String surname) {
		return bookingService.getBookingsByUser(name, surname);
	}

	@GetMapping("/bookings/reason-null")
	public List<BookingVO> getBookingsByReasonNull() {
		return bookingService.getBookingsByReasonNull();
	}

	@GetMapping("/bookings/after/{date}")
	public List<BookingVO> getBookingsAfter(@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate date) {
		return bookingService.getBookingsAfter(date);
	}

	@GetMapping("/bookings/accepteds")
	public List<BookingVO> getBookingsAccepted() {
		return bookingService.getBookingsAccepted();
	}

}
