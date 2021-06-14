package com.cjgmj.bookingsgraphql.converter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.cjgmj.bookingsgraphql.entity.RoomEntity;
import com.cjgmj.bookingsgraphql.graphql.object.type.Room;

public class RoomConverter {

	public static Room entityToRoom(RoomEntity entity) {
		if (entity == null) {
			return null;
		}

		final Room room = new Room();

		room.setId(entity.getId());
		room.setName(entity.getName());
		room.setNumber(entity.getNumber());
		room.setPlace(entity.getPlace());

		return room;
	}

	public static List<Room> entitiesToRooms(Iterable<RoomEntity> entities) {
		if (entities == null) {
			return null;
		}

		return StreamSupport.stream(entities.spliterator(), false).map(RoomConverter::entityToRoom)
				.collect(Collectors.toList());
	}

}
