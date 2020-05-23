package com.cjgmj.bookings.converter;

import java.util.LinkedList;
import java.util.List;

import com.cjgmj.bookings.entity.BookingEntity;
import com.cjgmj.bookings.vo.BookingVO;

public class BookingConverter {

	public static BookingVO bookingEntityToVO(BookingEntity entity) {
		if (entity == null) {
			return null;
		}

		BookingVO vo = new BookingVO();

		vo.setId(entity.getId());
		vo.setUser(UserConverter.userEntityToVO(entity.getUser()));
		vo.setRoom(RoomConverter.roomEntityToVO(entity.getRoom()));
		vo.setDate(entity.getDate());
		vo.setReason(entity.getReason());
		vo.setAccepted(entity.getAccepted());
		vo.setBooking(entity.getBooking());

		return vo;
	}

	public static List<BookingVO> bookingsEntityToVO(Iterable<BookingEntity> entities) {
		if (entities == null)
			return null;

		List<BookingVO> ret = new LinkedList<>();
		for (BookingEntity entity : entities) {
			ret.add(BookingConverter.bookingEntityToVO(entity));
		}

		return ret;
	}

	public static BookingEntity bookingVOToEntity(BookingVO vo) {
		if (vo == null) {
			return null;
		}

		BookingEntity entity = new BookingEntity();

		entity.setId(vo.getId());
		entity.setUser(UserConverter.userVOToEntity(vo.getUser()));
		entity.setRoom(RoomConverter.roomVOToEntity(vo.getRoom()));
		entity.setDate(vo.getDate());
		entity.setReason(vo.getReason());
		entity.setAccepted(vo.getAccepted());
		entity.setBooking(vo.getBooking());

		return entity;
	}

	public static List<BookingEntity> bookingsVOToEntity(Iterable<BookingVO> entities) {
		if (entities == null)
			return null;

		List<BookingEntity> ret = new LinkedList<>();
		for (BookingVO entity : entities) {
			ret.add(BookingConverter.bookingVOToEntity(entity));
		}

		return ret;
	}

}
