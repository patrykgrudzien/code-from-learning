package com.jurik99.topic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.jurik99.topic.domain.Topic;
import com.jurik99.topic.service.TopicService;

// look into <dependency> section im pom.xml and "spring-boot-devtools" -> replacement for paid JRebel
@RestController
public class TopicController {

	private final TopicService topicService;

	@Autowired
	public TopicController(final TopicService topicService) {
		this.topicService = topicService;
	}

	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@GetMapping("/topics/{topicId}")
	public Topic getTopic(@PathVariable("topicId") final String topicId) {
		return topicService.getTopic(topicId);
	}

	@PostMapping("/topics")
	public void addTopic(@RequestBody final Topic topic) {
		topicService.addTopic(topic);
	}

	@PutMapping("/topics/{topicId}")
	public void updateTopic(@RequestBody final Topic topic) {
		topicService.updateTopic(topic);
	}

	@DeleteMapping(value = "/topics/{topicId}")
	public void deleteTopic(@PathVariable final String topicId) {
		topicService.deteleTopic(topicId);
	}
}
