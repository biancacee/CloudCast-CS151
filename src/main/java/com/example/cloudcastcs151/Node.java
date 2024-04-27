package com.example.cloudcastcs151;

public class Node {
    String username;
    String password;
    String city;
    Node next;
    
    public Node(String username, String password, String city) 
    {
        this.username = username;
        this.password = password;
        this.city = city;
        this.next = null;
    }
    
    String getUsername() 
    {
    	return username;
    }
    
    String getPassword() 
    {
    	return password;
    }
    
    String getCity() 
    {
    	return city;
    }
    
}
