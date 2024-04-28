package com.example.cloudcastcs151;

import java.util.HashMap;

public class SignUp {
	
	private HashMap<String, User> userMap;
	
    public SignUp() 
    {
    	userMap = new HashMap<>();
    }
    
    public void add(String username, String password, String city) 
    {
    	 userMap.put(username, new User(username, password, city));
    }
    
    public boolean contains(String username) 
    {
        return userMap.containsKey(username);
    }
    
   public boolean checkPassword(String username, String password) 
    {
    	if (userMap.containsKey(username))
    	{
    		return userMap.get(username).getPassword().equals(password);
    	}
    	return false;
    }
    
    public void delete(String username) 
    {
    	userMap.remove(username);
    }
    
}
