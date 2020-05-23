package com.cjgmj.room.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjgmj.commons.vo.RoomVO;
import com.cjgmj.room.service.IRoomService;

@RestController
@RequestMapping
public class RoomController {

	@Autowired
	private IRoomService roomService;

	@GetMapping
	public List<RoomVO> getRooms() {
		return roomService.getRooms();
	}

	@GetMapping("/{id}")
	public RoomVO getRoomById(@PathVariable Long id) {
		return roomService.getRoomById(id);
	}

	@PostMapping("/ids")
	public List<RoomVO> getRoomsByIds(@RequestBody List<Long> ids) {
		return roomService.getRoomsByIds(ids);
	}

}
