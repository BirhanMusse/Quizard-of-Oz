package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.DAO.TopicDAO;
import com.revature.DAO.TopicDAOImpl;
import com.revature.beans.Topic;


@Service 
public class TopicServiceImpl implements TopicService {

	// instance variables
	private TopicDAO td = new TopicDAOImpl();

	// service methods
	@Override
	public Topic getTopicById(int id) {
		return td.getTopicById(id);
	}

	@Override
	public List<Topic> getAllTopics() {
		return td.getAllTopics();
	}

	@Override
	public void addTopic(Topic topic) {
		td.addTopic(topic);
	}

	@Override
	public boolean updateTopic(Topic topic) {
		return td.updateTopic(topic);
	}

	@Override
	public void deleteTopic(Topic topic) {
		td.deleteTopic(topic);
	}

}
