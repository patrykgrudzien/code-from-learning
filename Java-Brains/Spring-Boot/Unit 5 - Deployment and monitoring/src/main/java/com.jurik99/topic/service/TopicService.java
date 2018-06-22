package com.jurik99.topic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.jurik99.topic.domain.Topic;
import com.jurik99.topic.repository.TopicRepository;

@Service
public class TopicService {

	private TopicRepository topicRepository;

	@Autowired
	public TopicService(final TopicRepository topicRepository) {
		this.topicRepository = topicRepository;
	}

	/*
	 * The framework sees the embedded Derby database in the classpath and assumes that to be the database to
	 * connect to. No connection information necessary !!!
	 */
	public List<Topic> getAllTopics() {
		final List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		               .forEach(topics::add);
		return topics;
	}

	public Topic getTopic(final String topicId) {
		return topicRepository.findOne(topicId);
	}

	public void addTopic(final Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(final Topic topic) {
		// there is no update() method but save() can do BOTH
		topicRepository.save(topic);
	}

	public void deteleTopic(final String topicId) {
		topicRepository.delete(topicId);
	}
}
