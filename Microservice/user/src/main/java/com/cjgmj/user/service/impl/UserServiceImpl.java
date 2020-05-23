package com.cjgmj.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cjgmj.commons.vo.UserVO;
import com.cjgmj.user.converter.UserConverter;
import com.cjgmj.user.entity.UserEntity;
import com.cjgmj.user.repository.UserRepository;
import com.cjgmj.user.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserVO> getUsers() {
		return UserConverter.usersEntityToVO(userRepository.findAll());
	}

	@Override
	public Page<UserVO> getUsersPage(Integer numPage, Integer pageSize) {
		Page<UserEntity> user = userRepository.findAll(PageRequest.of(numPage, pageSize));
		List<UserVO> usersVO = UserConverter.usersEntityToVO(user.getContent());

		return new PageImpl<UserVO>(usersVO, PageRequest.of(numPage, pageSize), user.getTotalElements());
	}

	@Override
	public UserVO getUserById(Long id) {
		return UserConverter.userEntityToVO(userRepository.findById(id).orElse(null));
	}

	@Override
	public List<UserVO> getUserLike(String text) {
		String t = "%" + text + "%";
		return UserConverter.usersEntityToVO(userRepository.findByNameLikeOrSurnameLike(t, t));
	}

	@Override
	public List<UserVO> getUserOrderName() {
		return UserConverter.usersEntityToVO(userRepository.findByOrderByNameAsc());
	}

	@Override
	public List<UserVO> getUserMinor(Integer age) {
		return UserConverter.usersEntityToVO(userRepository.findByAgeLessThan(age));
	}

	@Override
	public UserVO insertOrUpdateUser(UserVO user) {
		return UserConverter.userEntityToVO(userRepository.save(UserConverter.userVOToEntity(user)));

	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<UserVO> getUsersByIds(List<Long> ids) {
		return UserConverter.usersEntityToVO(userRepository.findByIdIn(ids));
	}

	@Override
	public List<UserVO> getUsersByNameAndSurname(String name, String surname) {
		return UserConverter.usersEntityToVO(userRepository.findByNameAndSurname(name, surname));
	}

}
