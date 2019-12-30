package com.app;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/** Jpa repository for login user table */
public interface UserRepository extends JpaRepository<Users, Integer> {
	Optional<Users> findByUserName(String userName);

}
