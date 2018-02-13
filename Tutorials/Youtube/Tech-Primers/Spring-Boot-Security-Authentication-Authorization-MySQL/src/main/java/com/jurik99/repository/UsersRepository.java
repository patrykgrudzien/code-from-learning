package com.jurik99.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.jurik99.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByName(String username);
}
