package com.example.cloudcastcs151;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Text actiontarget;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    SignUp signUpManager;
    @FXML
    public void initialize() 
    {
        signUpManager = Singleton.getInstance();
    }
    @FXML
    public void switchtoMain(ActionEvent event) throws IOException {
        //Login code logic goes here
    	String username = usernameField.getText();
        String password = passwordField.getText();

		
		if (signUpManager.checkPassword(username, password))
        {
            root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else 
        {
            actiontarget.setText("No matching account found");
        }
    }
    @FXML
    public void switchtoSignUp(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
