package com.cjgmj.bookingsgraphql.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cjgmj.bookingsgraphql.entity.BookingEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

	List<BookingEntity> findByRoomId(Integer id);

	List<BookingEntity> findByDateBetween(LocalDateTime from, LocalDateTime to);

	@Query("SELECT b FROM Booking b INNER JOIN User u ON b.userId = u.id WHERE u.name = :name AND u.surname = :surname")
	List<BookingEntity> findByUserNameAndUserSurname(String name, String surname);

	List<BookingEntity> findByReasonIsNull();

	List<BookingEntity> findByDateAfter(LocalDateTime date);

	List<BookingEntity> findByAcceptedTrue();

}
