package com.cjgmj.bookings.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cjgmj.bookings.vo.UserVO;

public interface IUserService {

	public List<UserVO> getUsers();

	public Page<UserVO> getUsersPage(Integer numPage, Integer pageSize);

	public UserVO getUserById(Long id);

	public List<UserVO> getUserLike(String text);

	public List<UserVO> getUserOrderName();

	public List<UserVO> getUserMinor(Integer age);

	public UserVO insertOrUpdateUser(UserVO user);

	public void deleteUser(Long id);

}
