package com.cjgmj.booking.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjgmj.commons.vo.UserVO;

@FeignClient(name = "user")
public interface UserClient {

	@GetMapping("/{id}")
	public UserVO getUserById(@PathVariable Long id);

	@PostMapping("/ids")
	public List<UserVO> getUsersByIds(@RequestBody List<Long> ids);

	@GetMapping("/user")
	public List<UserVO> getUsersByNameAndSurname(@RequestParam String name, @RequestParam String surname);

}
