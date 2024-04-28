package com.example.cloudcastcs151;

public class SignUp {
private Node head;
    public SignUp() 
    {
        head = null;
    }
    public void add(String username, String password, String city) 
    {
        Node node = new Node(username, password, city);
        if (head == null) 
        {
            head = node;
        } 
        else 
        {
            Node curr = head;
            while (curr.next != null) 
            {
                curr = curr.next;
            }
            curr.next = node;
        }
    }
    public boolean contains(String username) 
    {
        Node curr = head;
        while (curr != null)
        {
            if (curr.username.equals(username)) 
            {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    public boolean checkPassword(String username, String password) 
    {
        Node curr = head;
        while (curr != null) 
        {
            if (curr.username.equals(username) && curr.password.equals(password)) 
            {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    public void delete(String username) 
    {
    	Node prev = head;
        Node curr = head.next;
        
        if (head.username.equals(username)) 
        {
            head = head.next;
            return;
        }
        while (curr != null) 
        {
            if (curr.username.equals(username)) 
            {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    
}
