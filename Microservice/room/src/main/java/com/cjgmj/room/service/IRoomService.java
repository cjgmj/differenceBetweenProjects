package com.cjgmj.room.service;

import java.util.List;

import com.cjgmj.commons.vo.RoomVO;

public interface IRoomService {

	public List<RoomVO> getRooms();

	public RoomVO getRoomById(Long id);

	public List<RoomVO> getRoomsByIds(List<Long> ids);

}
