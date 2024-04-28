package com.example.cloudcastcs151;

public class Node {
    static String username;
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
    public static boolean contains(String loginusername) {
        return username.equals(loginusername);
    }
    public static boolean checkPassword(String username, String password) {
        return username.equals(password);
    }
}
