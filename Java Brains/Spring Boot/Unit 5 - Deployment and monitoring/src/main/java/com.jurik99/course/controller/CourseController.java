package com.jurik99.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.jurik99.course.domain.Course;
import com.jurik99.course.service.CourseService;
import com.jurik99.topic.domain.Topic;

// look into <dependency> section im pom.xml and "spring-boot-devtools" -> replacement for paid JRebel
@RestController
public class CourseController {

	private final CourseService courseService;

	@Autowired
	public CourseController(final CourseService courseService) {
		this.courseService = courseService;
	}

	@GetMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable final String topicId) {
		return courseService.getAllCourses(topicId);
	}

	@GetMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable final String courseId) {
		return courseService.getCourse(courseId);
	}

	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@PathVariable final String topicId,
	                      @RequestBody final Course course) {
		course.setTopic(new Topic(null, topicId, "", ""));
		courseService.addCourse(course);
	}

	@PutMapping("/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@PathVariable final String topicId,
	                         @RequestBody final Course course) {
		course.setTopic(new Topic(null, topicId, "", ""));
		courseService.updateCourse(course);
	}

	@DeleteMapping("/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable final String courseId) {
		courseService.deleteCourse(courseId);
	}
}
