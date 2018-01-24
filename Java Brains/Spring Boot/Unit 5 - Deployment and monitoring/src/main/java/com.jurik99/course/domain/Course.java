package com.jurik99.course.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.jurik99.topic.domain.Topic;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {

	// UUID is needed here just for Apache Derby purposes (without it there are some exceptions on requests)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String uuid;

	@Id
	private String id;
	private String name;
	private String description;

	@ManyToOne
	private Topic topic;

	// --- CUSTOM CONSTRUCTOR ---
	public Course(final String id, final String name, final String description, final String topicId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(null, topicId, "", "");
	}
}
