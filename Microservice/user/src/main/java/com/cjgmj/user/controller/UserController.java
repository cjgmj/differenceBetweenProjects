package com.cjgmj.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cjgmj.commons.vo.UserVO;
import com.cjgmj.user.service.IUserService;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping
	public List<UserVO> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/page")
	public Page<UserVO> getUsersPage(@RequestParam Integer numPage, @RequestParam Integer pageSize) {
		return userService.getUsersPage(numPage, pageSize);
	}

	@GetMapping("/{id}")
	public UserVO getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@GetMapping("/like/{text}")
	public List<UserVO> getUserLike(@PathVariable String text) {
		return userService.getUserLike(text);
	}

	@GetMapping("/order/name")
	public List<UserVO> getUserOrderName() {
		return userService.getUserOrderName();
	}

	@GetMapping("/minor/{age}")
	public List<UserVO> getUserMinor(@PathVariable Integer age) {
		return userService.getUserMinor(age);
	}

	@PostMapping
	public UserVO insertUser(@RequestBody UserVO user) {
		return userService.insertOrUpdateUser(user);
	}

	@PutMapping
	public UserVO updateUser(@RequestBody UserVO user) {
		return userService.insertOrUpdateUser(user);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

	@PostMapping("/ids")
	public List<UserVO> getUsersByIds(@RequestBody List<Long> ids) {
		return userService.getUsersByIds(ids);
	}

	@GetMapping("/user")
	public List<UserVO> getUsersByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
		return userService.getUsersByNameAndSurname(name, surname);
	}
}
