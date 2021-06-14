package com.cjgmj.bookingsgraphql.service;

import java.util.List;

import com.cjgmj.bookingsgraphql.graphql.object.type.Room;

public interface IRoomService {

	List<Room> getRooms();

}
