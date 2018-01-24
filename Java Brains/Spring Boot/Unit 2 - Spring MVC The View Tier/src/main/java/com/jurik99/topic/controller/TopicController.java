package com.jurik99.topic.controller;

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

import com.jurik99.topic.domain.Topic;
import com.jurik99.topic.service.TopicService;

@RestController
public class TopicController {

	private final TopicService topicService;

	@Autowired
	public TopicController(final TopicService topicService) {
		this.topicService = topicService;
	}

	// --- Default GET ---
	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		// --- List<Topic> as returned object will be automatically converted into JSON format by Spring MVC ---
		return topicService.getAllTopics();
	}

	/*
	 *  The key difference between @RequestParam and @PathParam is that @RequestParam used for accessing the values
	 *  of the query parameters where @PathVariable is used for accessing the values from the URI template.
	 */
	@GetMapping("/topics/{topicId}")
	public Topic getTopic(@PathVariable("topicId") final String topicId) {
		return topicService.getTopic(topicId);
	}

	// --- Map that request to any POST calls that support "/topics" path ---
	@PostMapping(value = "/topics")
	public void addTopic(@RequestBody final Topic topic) {
		/*
		 *  @RequestBody
		 *  Request itself is gonna contain a JSON representation of TOPIC instance and we're asking to take this
		 *  REQUEST BODY and convert it into a TOPIC instance and pass to the "addTopic()" method.
		 */
		topicService.addTopic(topic);
	}

	@PutMapping(value = "/topics/{topicId}")
	public void updateTopic(@RequestBody final Topic topic, @PathVariable final String topicId) {
		topicService.updateTopic(topicId, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}")
	public void deleteTopic(@PathVariable final String topicId) {
		topicService.deteleTopic(topicId);
	}
}
