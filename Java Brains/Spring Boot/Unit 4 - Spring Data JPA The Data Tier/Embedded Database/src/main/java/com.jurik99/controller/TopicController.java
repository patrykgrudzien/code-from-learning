package com.jurik99.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.jurik99.model.Topic;
import com.jurik99.service.TopicService;

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
	public void updateTopic(@RequestBody final Topic topic, @PathVariable final String topicId) {
		topicService.updateTopic(topicId, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}")
	public void deleteTopic(@PathVariable final String topicId) {
		topicService.deteleTopic(topicId);
	}
}
