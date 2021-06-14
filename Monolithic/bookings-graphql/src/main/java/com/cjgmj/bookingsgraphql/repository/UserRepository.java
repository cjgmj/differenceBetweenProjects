package com.cjgmj.bookingsgraphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cjgmj.bookingsgraphql.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	List<UserEntity> findByNameLikeOrSurnameLike(String text, String text2);

	List<UserEntity> findByNameLikeIgnoreCaseOrSurnameLikeIgnoreCase(String text, String text2);

	@Query("SELECT u FROM User u WHERE u.name LIKE :text OR u.surname LIKE :text")
	List<UserEntity> findByNameOrSurname(String text);

	List<UserEntity> findByOrderByNameAsc();

	List<UserEntity> findByAgeLessThan(Integer age);

}
