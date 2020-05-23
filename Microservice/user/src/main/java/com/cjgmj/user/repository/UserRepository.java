package com.cjgmj.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cjgmj.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public List<UserEntity> findByNameLikeOrSurnameLike(String text, String text2);

	@Query("SELECT u FROM User u WHERE u.name LIKE :text OR u.surname LIKE :text")
	public List<UserEntity> findByNameOrSurname(String text);

	public List<UserEntity> findByOrderByNameAsc();

	public List<UserEntity> findByAgeLessThan(Integer age);

	public List<UserEntity> findByIdIn(List<Long> ids);

	public List<UserEntity> findByNameAndSurname(String name, String surname);

}
