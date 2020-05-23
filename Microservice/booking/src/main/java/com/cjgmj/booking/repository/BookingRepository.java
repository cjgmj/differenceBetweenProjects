package com.cjgmj.booking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjgmj.booking.entity.BookingEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

	public List<BookingEntity> findByRoom(Long id);

	public List<BookingEntity> findByDateBetween(LocalDateTime from, LocalDateTime to);

	public List<BookingEntity> findByUserIn(List<Long> usersId);

	public List<BookingEntity> findByReasonIsNull();

	public List<BookingEntity> findByDateAfter(LocalDateTime date);

	public List<BookingEntity> findByAcceptedTrue();

}
