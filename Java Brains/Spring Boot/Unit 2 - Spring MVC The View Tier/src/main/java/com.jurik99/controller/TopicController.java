package com.jurik99.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	// --- Default GET ---
	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		// --- List<Topic> as returned object will be automatically converted into JSON format by Spring MVC ---
		return topicService.getAllTopics();
	}

	/*
	 *  The key difference between @RequestParam and @PathParam is that @RequestParam used for accessing the values
	 *  of the query parameters where @PathVariable is used for accessing the values from the URI template.
	 */
	@RequestMapping("/topics/{topicId}")
	public Topic getTopic(@PathVariable("topicId") final String topicId)
	{
		return topicService.getTopic(topicId);
	}

	// --- Map that request to any POST calls that support "/topics" path ---
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody final Topic topic)
	{
		/*
		 *  @RequestBody
		 *  Request itself is gonna contain a JSON representation of TOPIC instance and we're asking to take this
		 *  REQUEST BODY and convert it into a TOPIC instance and pass to the "addTopic()" method.
		 */
		topicService.addTopic(topic);
	}
}
