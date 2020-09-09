package com.revature.DAO;

import java.util.List;

import com.revature.beans.Result;


public interface ResultDAO {
	
public Result getResultById(int id); 
	
	public List<Result> getAllResults(); 
	
	public void addResult(Result result); 
	
	public boolean updateResult(Result result); 
	
	public void deleteResult(Result result);
}
