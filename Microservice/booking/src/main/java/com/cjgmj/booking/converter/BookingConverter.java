package com.cjgmj.booking.converter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjgmj.booking.client.RoomClient;
import com.cjgmj.booking.client.UserClient;
import com.cjgmj.booking.entity.BookingEntity;
import com.cjgmj.commons.vo.BookingVO;
import com.cjgmj.commons.vo.RoomVO;
import com.cjgmj.commons.vo.UserVO;

@Component
public class BookingConverter {

	private static UserClient userClient;

	private static RoomClient roomClient;

	@Autowired
	public void setUserClient(UserClient userClient) {
		BookingConverter.userClient = userClient;
	}

	@Autowired
	public void setRoomClient(RoomClient roomClient) {
		BookingConverter.roomClient = roomClient;
	}

	public static BookingVO bookingEntityToVO(BookingEntity entity, Map<Long, UserVO> users, Map<Long, RoomVO> rooms) {
		if (entity == null) {
			return null;
		}

		BookingVO vo = new BookingVO();

		vo.setId(entity.getId());

		if (users == null) {
			vo.setUser(userClient.getUserById(entity.getUser()));
		} else {
			vo.setUser(users.get(entity.getUser()));
		}

		if (rooms == null) {
			vo.setRoom(roomClient.getRoomById(entity.getRoom()));
		} else {
			vo.setRoom(rooms.get(entity.getRoom()));
		}

		vo.setDate(entity.getDate());
		vo.setReason(entity.getReason());
		vo.setAccepted(entity.getAccepted());
		vo.setBooking(entity.getBooking());

		return vo;
	}

	public static List<BookingVO> bookingsEntityToVO(Collection<BookingEntity> entities) {
		if (entities == null)
			return null;

		// Obtener listas de Id
		List<Long> userIds = entities.stream().map(BookingEntity::getUser).collect(Collectors.toList());
		List<Long> roomsIds = entities.stream().map(BookingEntity::getRoom).collect(Collectors.toList());

		// Maps de los VOs
		Map<Long, UserVO> mapUsers = userClient.getUsersByIds(userIds).stream()
				.collect(Collectors.toMap(UserVO::getId, Function.<UserVO>identity()));
		Map<Long, RoomVO> mapRooms = roomClient.getRoomsByIds(roomsIds).stream()
				.collect(Collectors.toMap(RoomVO::getId, Function.<RoomVO>identity()));

		List<BookingVO> ret = new LinkedList<>();
		for (BookingEntity entity : entities) {
			ret.add(BookingConverter.bookingEntityToVO(entity, mapUsers, mapRooms));
		}

		return ret;
	}

	public static BookingEntity bookingVOToEntity(BookingVO vo) {
		if (vo == null) {
			return null;
		}

		BookingEntity entity = new BookingEntity();

		entity.setId(vo.getId());
		entity.setUser(vo.getUser().getId());
		entity.setRoom(vo.getRoom().getId());
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
