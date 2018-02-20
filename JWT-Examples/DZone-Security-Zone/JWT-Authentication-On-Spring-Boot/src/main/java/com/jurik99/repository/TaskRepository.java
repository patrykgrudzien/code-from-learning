package com.jurik99.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jurik99.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {}
