package com.revature.service;

import java.util.List;

import com.revature.beans.Topic;

public interface TopicService {

public Topic getTopicById(int id); 
	
	public List<Topic> getAllTopics(); 
	
	public void addTopic(Topic topic); 
	
	public boolean updateTopic(Topic topic); 
	
	public void deleteTopic(Topic topic); 
	
}
