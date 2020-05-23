package com.cjgmj.booking.service;

import java.time.LocalDate;
import java.util.List;

import com.cjgmj.commons.vo.BookingVO;

public interface IBookingService {

	public BookingVO bookingRoom(BookingVO booking);

	public List<BookingVO> getBookingsByRoom(Long id);

	public List<BookingVO> getBookingsBetween(LocalDate from, LocalDate to);

	public List<BookingVO> getBookingsByUser(String name, String surname);

	public List<BookingVO> getBookingsByReasonNull();

	public List<BookingVO> getBookingsAfter(LocalDate date);

	public List<BookingVO> getBookingsAccepted();

}
