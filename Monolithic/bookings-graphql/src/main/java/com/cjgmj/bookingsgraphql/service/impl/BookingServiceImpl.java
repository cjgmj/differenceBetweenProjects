package com.cjgmj.bookingsgraphql.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjgmj.bookingsgraphql.converter.BookingConverter;
import com.cjgmj.bookingsgraphql.entity.BookingEntity;
import com.cjgmj.bookingsgraphql.graphql.object.input.BookingInput;
import com.cjgmj.bookingsgraphql.graphql.object.type.Booking;
import com.cjgmj.bookingsgraphql.repository.BookingRepository;
import com.cjgmj.bookingsgraphql.service.IBookingService;

@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public Booking bookingRoom(BookingInput booking) {
		final BookingEntity entity = BookingConverter.inputToEntity(booking);

		return BookingConverter.entityToBooking(this.bookingRepository.save(entity));
	}

	@Override
	public List<Booking> getBookingsByRoom(Integer id) {
		return BookingConverter.entitiesToBookings(this.bookingRepository.findByRoomId(id));
	}

	@Override
	public List<Booking> getBookingsBetween(LocalDate from, LocalDate to) {
		return BookingConverter.entitiesToBookings(
				this.bookingRepository.findByDateBetween(from.atStartOfDay(), to.atTime(LocalTime.MAX)));
	}

	@Override
	public List<Booking> getBookingsByUser(String name, String surname) {
		return BookingConverter.entitiesToBookings(this.bookingRepository.findByUserNameAndUserSurname(name, surname));
	}

	@Override
	public List<Booking> getBookingsByReasonNull() {
		return BookingConverter.entitiesToBookings(this.bookingRepository.findByReasonIsNull());
	}

	@Override
	public List<Booking> getBookingsAfter(LocalDate date) {
		return BookingConverter.entitiesToBookings(this.bookingRepository.findByDateAfter(date.atStartOfDay()));
	}

	@Override
	public List<Booking> getBookingsAccepted() {
		return BookingConverter.entitiesToBookings(this.bookingRepository.findByAcceptedTrue());
	}

}
