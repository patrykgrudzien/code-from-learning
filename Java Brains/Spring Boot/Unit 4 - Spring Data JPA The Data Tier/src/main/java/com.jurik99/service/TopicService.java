package com.jurik99.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
	// --- When we create a list from "Arrays.asList()", the list is IMMUTABLE (cannot add or remove smth) !!! ---
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring","Spring Framework","Spring Framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("javascript", "JavaScript", "JavaScript Description")));

	public List<Topic> getAllTopics()
	{
		return topics;
	}

	public Topic getTopic(final String topicId)
	{
		return topics.stream().filter(topic -> topic.getId().equals(topicId)).findFirst().get();
	}

	public void addTopic(final Topic topic)
	{
		topics.add(topic);
	}

	@SuppressWarnings("Duplicates")
	public void updateTopic(final String topicId, final Topic topic)
	{
		for (int i = 0; i < topics.size(); i++)
		{
			final Topic t = topics.get(i);
			if (t.getId().equals(topicId))
			{
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deteleTopic(final String topicId)
	{
		topics.removeIf(topic -> topic.getId().equals(topicId));
	}

}
