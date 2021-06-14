package com.cjgmj.bookingsgraphql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.cjgmj.bookingsgraphql.converter.UserConverter;
import com.cjgmj.bookingsgraphql.entity.UserEntity;
import com.cjgmj.bookingsgraphql.graphql.object.input.UserInput;
import com.cjgmj.bookingsgraphql.graphql.object.type.User;
import com.cjgmj.bookingsgraphql.repository.UserRepository;
import com.cjgmj.bookingsgraphql.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return UserConverter.entitiesToUsers(this.userRepository.findAll());
	}

	@Override
	public Page<User> getUsersPage(Integer numPage, Integer pageSize) {
		final PageRequest pageRequest = PageRequest.of(numPage, pageSize, Sort.by(new Order(Direction.ASC, "name")));

		final Page<UserEntity> user = this.userRepository.findAll(pageRequest);
		final List<User> users = UserConverter.entitiesToUsers(user.getContent());

		return new PageImpl<>(users, pageRequest, user.getTotalElements());
	}

	@Override
	public User getUserById(Integer id) {
		return UserConverter.entityToUser(this.userRepository.findById(id).orElse(null));
	}

	@Override
	public List<User> getUserLike(String text) {
		final String t = "%" + text + "%";
		return UserConverter.entitiesToUsers(this.userRepository.findByNameLikeIgnoreCaseOrSurnameLikeIgnoreCase(t, t));
	}

	@Override
	public List<User> getUserOrderName() {
		return UserConverter.entitiesToUsers(this.userRepository.findByOrderByNameAsc());
	}

	@Override
	public List<User> getUserMinor(Integer age) {
		return UserConverter.entitiesToUsers(this.userRepository.findByAgeLessThan(age));
	}

	@Override
	public User insertUser(UserInput user) {
		return UserConverter.entityToUser(this.userRepository.save(UserConverter.inputToEntity(user)));

	}

	@Override
	public User updateUser(Integer id, UserInput user) {
		final UserEntity userEntity = UserConverter.inputToEntity(user);

		userEntity.setId(id);

		return UserConverter.entityToUser(this.userRepository.save(userEntity));

	}

	@Override
	public User deleteUser(Integer id) {
		final User user = this.userRepository.findById(id).map(UserConverter::entityToUser).orElse(null);

		this.userRepository.deleteById(id);

		return user;
	}

}
