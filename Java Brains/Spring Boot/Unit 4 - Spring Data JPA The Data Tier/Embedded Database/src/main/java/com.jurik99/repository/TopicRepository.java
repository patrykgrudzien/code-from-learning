package com.jurik99.repository;

import org.springframework.data.repository.CrudRepository;

import com.jurik99.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {}
