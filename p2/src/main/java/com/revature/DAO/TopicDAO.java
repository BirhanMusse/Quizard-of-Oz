package com.revature.DAO;

import java.util.List;

import com.revature.beans.Topic;


public interface TopicDAO {
	
	public Topic getTopicById(int id); 
	
	public List<Topic> getAllTopics(); 
	
	public void addTopic(Topic topic); 
	
	public boolean updateTopic(Topic topic); 
	
	public void deleteTopic(Topic topic);
}
