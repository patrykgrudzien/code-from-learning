package com.jurik99.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jurik99.domain.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

	ApplicationUser findByUsername(String username);
}
