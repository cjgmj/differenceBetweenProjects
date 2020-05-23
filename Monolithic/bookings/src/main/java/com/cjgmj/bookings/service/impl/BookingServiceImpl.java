package com.cjgmj.bookings.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjgmj.bookings.converter.BookingConverter;
import com.cjgmj.bookings.repository.BookingRepository;
import com.cjgmj.bookings.service.IBookingService;
import com.cjgmj.bookings.vo.BookingVO;

@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public BookingVO bookingRoom(BookingVO booking) {
		return BookingConverter.bookingEntityToVO(bookingRepository.save(BookingConverter.bookingVOToEntity(booking)));
	}

	@Override
	public List<BookingVO> getBookingsByRoom(Long id) {
		return BookingConverter.bookingsEntityToVO(bookingRepository.findByRoomId(id));
	}

	@Override
	public List<BookingVO> getBookingsBetween(LocalDate from, LocalDate to) {
		return BookingConverter
				.bookingsEntityToVO(bookingRepository.findByDateBetween(from.atStartOfDay(), to.atTime(LocalTime.MAX)));
	}

	@Override
	public List<BookingVO> getBookingsByUser(String name, String surname) {
		return BookingConverter.bookingsEntityToVO(bookingRepository.findByUserNameAndUserSurname(name, surname));
	}

	@Override
	public List<BookingVO> getBookingsByReasonNull() {
		return BookingConverter.bookingsEntityToVO(bookingRepository.findByReasonIsNull());
	}

	@Override
	public List<BookingVO> getBookingsAfter(LocalDate date) {
		return BookingConverter.bookingsEntityToVO(bookingRepository.findByDateAfter(date.atStartOfDay()));
	}

	@Override
	public List<BookingVO> getBookingsAccepted() {
		return BookingConverter.bookingsEntityToVO(bookingRepository.findByAcceptedTrue());
	}

}
