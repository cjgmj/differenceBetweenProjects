package com.cjgmj.bookingsgraphql.converter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.cjgmj.bookingsgraphql.entity.BookingEntity;
import com.cjgmj.bookingsgraphql.graphql.object.input.BookingInput;
import com.cjgmj.bookingsgraphql.graphql.object.type.Booking;

public class BookingConverter {

	public static Booking entityToBooking(BookingEntity entity) {
		if (entity == null) {
			return null;
		}

		final Booking booking = new Booking();

		booking.setId(entity.getId());
		booking.setUser(UserConverter.entityToUser(entity.getUser()));
		booking.setRoom(RoomConverter.entityToRoom(entity.getRoom()));
		booking.setDate(entity.getDate());
		booking.setReason(entity.getReason());
		booking.setAccepted(entity.getAccepted());
		booking.setBooking(entity.getBooking());

		return booking;
	}

	public static List<Booking> entitiesToBookings(Iterable<BookingEntity> entities) {
		if (entities == null) {
			return null;
		}

		return StreamSupport.stream(entities.spliterator(), false).map(BookingConverter::entityToBooking)
				.collect(Collectors.toList());
	}

	public static BookingEntity inputToEntity(BookingInput input) {
		if (input == null) {
			return null;
		}

		final BookingEntity entity = new BookingEntity();

		entity.setDate(input.getDate());
		entity.setReason(input.getReason());
		entity.setAccepted(input.getAccepted());

		return entity;
	}

}
