package com.jurik99.course.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.jurik99.course.domain.Course;

public interface CourseRepository extends CrudRepository<Course, String> {

	List<Course> findByTopicId(String topicId);
}
