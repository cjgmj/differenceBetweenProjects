package com.cjgmj.bookingsgraphql.service;

import java.time.LocalDate;
import java.util.List;

import com.cjgmj.bookingsgraphql.graphql.object.input.BookingInput;
import com.cjgmj.bookingsgraphql.graphql.object.type.Booking;

public interface IBookingService {

	Booking bookingRoom(BookingInput booking);

	List<Booking> getBookingsByRoom(Integer id);

	List<Booking> getBookingsBetween(LocalDate from, LocalDate to);

	List<Booking> getBookingsByUser(String name, String surname);

	List<Booking> getBookingsByReasonNull();

	List<Booking> getBookingsAfter(LocalDate date);

	List<Booking> getBookingsAccepted();

}
