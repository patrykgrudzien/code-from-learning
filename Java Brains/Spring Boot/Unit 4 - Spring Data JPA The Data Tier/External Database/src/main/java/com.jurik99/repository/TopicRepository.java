package com.jurik99.repository;

import org.springframework.data.repository.CrudRepository;

import com.jurik99.model.Topic;

/*
 *  Spring Data JPA provides an interface that specifies CRUD methods and has implementation of that CRUD operations.
 *  <ENTITY that we wanna work with, ID class>.
 *  We just simply extends that Generic repository to automatically handle CRUD operations.
 */
public interface TopicRepository extends CrudRepository<Topic, String>
{

}
