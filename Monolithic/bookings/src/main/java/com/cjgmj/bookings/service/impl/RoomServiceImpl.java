package com.cjgmj.bookings.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjgmj.bookings.converter.RoomConverter;
import com.cjgmj.bookings.repository.RoomRepository;
import com.cjgmj.bookings.service.IRoomService;
import com.cjgmj.bookings.vo.RoomVO;

@Service
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public List<RoomVO> getRooms() {
		return RoomConverter.roomsEntityToVO(roomRepository.findAll());
	}

}
