package com.jurik99.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import com.jurik99.model.Topic;

/*
 * In Spring, business services are TYPICALLY - SINGLETON !!!
 * When the application starts up, Spring creates instance of that service and keeps in memory (registers it).
 */
@Service
public class TopicService
{
	private List<Topic> topics = Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
	                                           new Topic("java", "Core Java", "Core Java Description"),
	                                           new Topic("javascript", "JavaScript", "JavaScript Description"));

	public List<Topic> getAllTopics()
	{
		return topics;
	}

	public Topic getTopic(final String topicId)
	{
		return topics.stream().filter(topic -> topic.getId().equals(topicId)).findFirst().get();
	}
}
