package com.cjgmj.bookings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjgmj.bookings.entity.RoomEntity;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

}
