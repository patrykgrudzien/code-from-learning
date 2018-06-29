package com.jurik99.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.jurik99.course.domain.Course;
import com.jurik99.course.repository.CourseRepository;

@Service
public class CourseService {

	private CourseRepository courseRepository;

	@Autowired
	public CourseService(final CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	/*
	 * The framework sees the embedded Derby database in the classpath and assumes that to be the database to
	 * connect to. No connection information necessary !!!
	 */
	public List<Course> getAllCourses(final String topicId) {
		return courseRepository.findByTopicId(topicId)
		                       .stream()
		                       .collect(Collectors.toList());
	}

	public Course getCourse(final String courseId) {
		return courseRepository.findOne(courseId);
	}

	public void addCourse(final Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(final Course course) {
		// there is no update() method but save() can do BOTH
		courseRepository.save(course);
	}

	public void deleteCourse(final String courseId) {
		courseRepository.delete(courseId);
	}
}
