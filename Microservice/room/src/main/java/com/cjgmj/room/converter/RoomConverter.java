package com.cjgmj.room.converter;

import java.util.LinkedList;
import java.util.List;

import com.cjgmj.commons.vo.RoomVO;
import com.cjgmj.room.entity.RoomEntity;

public class RoomConverter {

	public static RoomVO roomEntityToVO(RoomEntity entity) {
		if (entity == null) {
			return null;
		}

		RoomVO vo = new RoomVO();

		vo.setId(entity.getId());
		vo.setName(entity.getName());
		vo.setNumber(entity.getNumber());
		vo.setPlace(entity.getPlace());

		return vo;
	}

	public static List<RoomVO> roomsEntityToVO(Iterable<RoomEntity> entities) {
		if (entities == null)
			return null;

		List<RoomVO> ret = new LinkedList<>();
		for (RoomEntity entity : entities) {
			ret.add(RoomConverter.roomEntityToVO(entity));
		}

		return ret;
	}

	public static RoomEntity roomVOToEntity(RoomVO vo) {
		if (vo == null) {
			return null;
		}

		RoomEntity entity = new RoomEntity();

		entity.setId(vo.getId());
		entity.setName(vo.getName());
		entity.setNumber(vo.getNumber());
		entity.setPlace(vo.getPlace());

		return entity;
	}

	public static List<RoomEntity> roomsVOToEntity(Iterable<RoomVO> entities) {
		if (entities == null)
			return null;

		List<RoomEntity> ret = new LinkedList<>();
		for (RoomVO entity : entities) {
			ret.add(RoomConverter.roomVOToEntity(entity));
		}

		return ret;
	}

}
