package com.asynchproductimp.impl.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asynchproductimp.impl.entities.User;

public interface UserDao extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
