package com.jurik99.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.jurik99.model.Topic;
import com.jurik99.service.TopicService;

@RestController
public class TopicController
{
	private final TopicService topicService;

	@Autowired
	public TopicController(final TopicService topicService)
	{
		this.topicService = topicService;
	}

	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		// --- List<Topic> as returned object will be automatically converted into JSON format by Spring MVC ---
		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{topicId}")
	public Topic getTopic(@PathVariable("topicId") final String topicId)
	{
		return topicService.getTopic(topicId);
	}
}
