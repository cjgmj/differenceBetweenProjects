package com.cjgmj.bookingsgraphql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjgmj.bookingsgraphql.converter.RoomConverter;
import com.cjgmj.bookingsgraphql.graphql.object.type.Room;
import com.cjgmj.bookingsgraphql.repository.RoomRepository;
import com.cjgmj.bookingsgraphql.service.IRoomService;

@Service
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public List<Room> getRooms() {
		return RoomConverter.entitiesToRooms(this.roomRepository.findAll());
	}

}
