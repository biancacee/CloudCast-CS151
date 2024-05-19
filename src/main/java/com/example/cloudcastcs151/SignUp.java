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
    	if (passwordIsValid(password) && nameIsValid(username))
    	{
   		userMap.put(username, new User(username, password, city));
   		}
    	
    }
    public boolean nameIsValid(String username) 
    {
    	boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;
        boolean hasNumber = false;

        if (username.length() < 4) //password length longer than 8 chars
        {
            return false;
        }

        for (char ch : username.toCharArray()) // checks each char of password input
        {
            if (Character.isUpperCase(ch)) //checks for uppercase
            {
                hasUpperCase = true;
            }
            if (Character.isLowerCase(ch)) //checks for lowercase
            {
                hasLowerCase = true;
            }
        }

        // Check if each required character type is present
        if (!hasUpperCase || !hasLowerCase) //no uppercase
        {
            return false;
        }
        
   	return true;
    }
    public boolean passwordIsValid(String password) 
    {
    	 boolean hasUpperCase = false;
         boolean hasLowerCase = false;
         boolean hasSpecialChar = false;
         boolean hasNumber = false;

         if (password.length() < 4) //password length longer than 8 chars
         {
             return false;
         }

         for (char ch : password.toCharArray()) // checks each char of password input
         {
             if (Character.isUpperCase(ch)) //checks for uppercase
             {
                 hasUpperCase = true;
             }
             if (Character.isLowerCase(ch)) //checks for lowercase
             {
                 hasLowerCase = true;
             }
             if (Character.isDigit(ch)) //checks for numbers
             {
                 hasNumber = true;
             }
         }

         // Check if each required character type is present
         if (!hasUpperCase || !hasLowerCase || !hasNumber) //no uppercase
         {
             return false;
         }
         
    	return true;
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
