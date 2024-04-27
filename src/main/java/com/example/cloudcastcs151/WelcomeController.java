package com.example.cloudcastcs151;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Text actiontarget;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField cityField;
    
    private SignUp signUpManager;
    
    @FXML
    public void initialize() 
    {
        signUpManager = new SignUp();
    }
    
    @FXML
    public void signUpUser(ActionEvent event) throws IOException {
    	//Code logic for Sign Up goes here

    	String username = usernameField.getText();
        String password = passwordField.getText();
        String city = cityField.getText();
        
        if (signUpManager.contains(username)) {
        	actiontarget.setText("This username already exists! Try again.");
            return;
        }
        
        signUpManager.add(username, password, city);
        actiontarget.setText("Account Created! Please Login.");
        
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchtoLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
