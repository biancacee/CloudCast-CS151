package com.example.cloudcastcs151;

class Singleton extends SignUp{

	  private static Singleton instance = null;
	  public SignUp signUp;
	  
	  private Singleton()
	  {
		  signUp = new SignUp();
	  }
	  public static Singleton getInstance()
	  {
	    if(instance == null)
	    {
	       instance = new Singleton();
	      }
	      return instance;
	  }
	}