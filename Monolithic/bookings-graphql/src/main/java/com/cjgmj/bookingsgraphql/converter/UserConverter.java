package com.cjgmj.bookingsgraphql.converter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.cjgmj.bookingsgraphql.entity.UserEntity;
import com.cjgmj.bookingsgraphql.graphql.object.input.UserInput;
import com.cjgmj.bookingsgraphql.graphql.object.type.User;

public class UserConverter {

	public static User entityToUser(UserEntity entity) {
		if (entity == null) {
			return null;
		}

		final User user = new User();

		user.setId(entity.getId());
		user.setName(entity.getName());
		user.setSurname(entity.getSurname());
		user.setEmail(entity.getEmail());
		user.setBirthdate(entity.getBirthdate());
		user.setAge(entity.getAge());

		return user;
	}

	public static List<User> entitiesToUsers(Iterable<UserEntity> entities) {
		if (entities == null) {
			return null;
		}

		return StreamSupport.stream(entities.spliterator(), false).map(UserConverter::entityToUser)
				.collect(Collectors.toList());
	}

	public static UserEntity inputToEntity(UserInput input) {
		if (input == null) {
			return null;
		}

		final UserEntity entity = new UserEntity();

		entity.setName(input.getName());
		entity.setSurname(input.getSurname());
		entity.setEmail(input.getEmail());
		entity.setBirthdate(input.getBirthdate());
		entity.setAge(input.getAge());

		return entity;
	}

}
