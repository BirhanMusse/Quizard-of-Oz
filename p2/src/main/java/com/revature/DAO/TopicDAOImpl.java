package com.revature.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Topic;
import com.revature.util.ConnectionUtil;

public class TopicDAOImpl implements TopicDAO {

	
	// variables
	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	// methods
	@Override
	public Topic getTopicById(int id) {
		Topic t = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			t = s.get(Topic.class, id);
			tx.commit();
		}
		return t;
	}

	@Override
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		// use a Query to retrieve all Topics
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			topics = s.createQuery("from Topic").getResultList();
			tx.commit();
			s.close();
		}
		return topics;
	}

	@Override
	public boolean updateTopic(Topic topic) {
		// this is awesome. We use session and the hibernate methods here
		// and NOT JDBC's connection and other interfaces.
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(topic);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public void addTopic(Topic topic) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(topic);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void deleteTopic(Topic topic) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(topic);
			tx.commit();
			s.close();
		}
	}
}
