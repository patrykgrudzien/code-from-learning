package com.jurik99.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import com.jurik99.model.Topic;

@RestController
public class TopicController
{
	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		// --- List<Topic> as returned object will be automatically converted into JSON format by Spring MVC ---
		return Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
		                     new Topic("java", "Core Java", "Core Java Description"),
		                     new Topic("javascript", "JavaScript", "JavaScript Description"));
		/*
		 * The generated JSON jas KEY names corresponding to property names (fields) of the Topic class
		 * (id, name, description).
		 * The JSON values are the values of THOSE PROPERTIES.
		 *
		 * Spring MVC converts that list to JSON AUTOMATICALLY !!!
		 */
	}
}
