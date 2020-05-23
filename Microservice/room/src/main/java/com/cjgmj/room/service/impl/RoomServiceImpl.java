package com.cjgmj.room.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjgmj.commons.vo.RoomVO;
import com.cjgmj.room.converter.RoomConverter;
import com.cjgmj.room.repository.RoomRepository;
import com.cjgmj.room.service.IRoomService;

@Service
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public List<RoomVO> getRooms() {
		return RoomConverter.roomsEntityToVO(roomRepository.findAll());
	}

	@Override
	public RoomVO getRoomById(Long id) {
		return RoomConverter.roomEntityToVO(roomRepository.findById(id).orElse(null));
	}

	@Override
	public List<RoomVO> getRoomsByIds(List<Long> ids) {
		return RoomConverter.roomsEntityToVO(roomRepository.findByIdIn(ids));
	}

}
