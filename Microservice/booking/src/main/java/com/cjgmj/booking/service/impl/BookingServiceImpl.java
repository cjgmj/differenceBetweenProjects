package com.cjgmj.booking.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjgmj.booking.client.UserClient;
import com.cjgmj.booking.converter.BookingConverter;
import com.cjgmj.booking.repository.BookingRepository;
import com.cjgmj.booking.service.IBookingService;
import com.cjgmj.commons.vo.BookingVO;
import com.cjgmj.commons.vo.UserVO;

@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private UserClient userClient;

	@Override
	public BookingVO bookingRoom(BookingVO booking) {
		return BookingConverter.bookingEntityToVO(bookingRepository.save(BookingConverter.bookingVOToEntity(booking)),
				null, null);
	}

	@Override
	public List<BookingVO> getBookingsByRoom(Long id) {
		return BookingConverter.bookingsEntityToVO(bookingRepository.findByRoom(id));
	}

	@Override
	public List<BookingVO> getBookingsBetween(LocalDate from, LocalDate to) {
		return BookingConverter
				.bookingsEntityToVO(bookingRepository.findByDateBetween(from.atStartOfDay(), to.atTime(LocalTime.MAX)));
	}

	@Override
	public List<BookingVO> getBookingsByUser(String name, String surname) {
		List<Long> usersId = userClient.getUsersByNameAndSurname(name, surname).stream().map(UserVO::getId)
				.collect(Collectors.toList());

		return BookingConverter.bookingsEntityToVO(bookingRepository.findByUserIn(usersId));
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
