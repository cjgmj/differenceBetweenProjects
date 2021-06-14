package com.cjgmj.bookingsgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjgmj.bookingsgraphql.entity.RoomEntity;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {

}
