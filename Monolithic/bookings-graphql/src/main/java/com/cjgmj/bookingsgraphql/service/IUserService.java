package com.cjgmj.bookingsgraphql.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cjgmj.bookingsgraphql.graphql.object.input.UserInput;
import com.cjgmj.bookingsgraphql.graphql.object.type.User;

public interface IUserService {

	List<User> getUsers();

	Page<User> getUsersPage(Integer numPage, Integer pageSize);

	User getUserById(Integer id);

	List<User> getUserLike(String text);

	List<User> getUserOrderName();

	List<User> getUserMinor(Integer age);

	User insertUser(UserInput user);

	User updateUser(Integer id, UserInput user);

	User deleteUser(Integer id);

}
