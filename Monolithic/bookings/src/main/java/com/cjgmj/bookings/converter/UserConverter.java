package com.cjgmj.bookings.converter;

import java.util.LinkedList;
import java.util.List;

import com.cjgmj.bookings.entity.UserEntity;
import com.cjgmj.bookings.vo.UserVO;

public class UserConverter {

	public static UserVO userEntityToVO(UserEntity entity) {
		if (entity == null) {
			return null;
		}

		UserVO vo = new UserVO();

		vo.setId(entity.getId());
		vo.setName(entity.getName());
		vo.setSurname(entity.getSurname());
		vo.setEmail(entity.getEmail());
		vo.setBirthdate(entity.getBirthdate());
		vo.setAge(entity.getAge());

		return vo;
	}

	public static List<UserVO> usersEntityToVO(Iterable<UserEntity> entities) {
		if (entities == null)
			return null;

		List<UserVO> ret = new LinkedList<>();
		for (UserEntity entity : entities) {
			ret.add(UserConverter.userEntityToVO(entity));
		}

		return ret;
	}

	public static UserEntity userVOToEntity(UserVO vo) {
		if (vo == null) {
			return null;
		}

		UserEntity entity = new UserEntity();

		entity.setId(vo.getId());
		entity.setName(vo.getName());
		entity.setSurname(vo.getSurname());
		entity.setEmail(vo.getEmail());
		entity.setBirthdate(vo.getBirthdate());
		entity.setAge(vo.getAge());

		return entity;
	}

	public static List<UserEntity> usersVOToEntity(Iterable<UserVO> entities) {
		if (entities == null)
			return null;

		List<UserEntity> ret = new LinkedList<>();
		for (UserVO entity : entities) {
			ret.add(UserConverter.userVOToEntity(entity));
		}

		return ret;
	}

}
