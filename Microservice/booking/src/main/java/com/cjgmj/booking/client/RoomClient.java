package com.cjgmj.booking.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cjgmj.commons.vo.RoomVO;

@FeignClient(name = "room")
public interface RoomClient {

	@GetMapping("/{id}")
	public RoomVO getRoomById(@PathVariable Long id);

	@PostMapping("/ids")
	public List<RoomVO> getRoomsByIds(@RequestBody List<Long> ids);

}
