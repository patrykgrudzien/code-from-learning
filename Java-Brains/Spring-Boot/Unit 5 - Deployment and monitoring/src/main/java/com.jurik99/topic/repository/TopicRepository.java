package com.jurik99.topic.repository;

import org.springframework.data.repository.CrudRepository;

import com.jurik99.topic.domain.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {}
