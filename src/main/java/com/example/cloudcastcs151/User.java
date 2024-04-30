package com.example.cloudcastcs151;

public class User {
    static String username;
    String password;
    String city;
    User next;
    public User(String username, String password, String city)
    {
        this.username = username;
        this.password = password;
        this.city = city;
        this.next = null;
    }
    public static boolean contains(String loginusername)
    {
        return username.equals(loginusername);
    }
    
    public String getPassword() 
    {
    	return password;
    }
}
