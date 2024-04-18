package com.example.cloudcastcs151;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIConnector {
    @FXML
    private Pane home;
    @FXML
    private Button submitCity;
    @FXML
    private Label displayTemp;
    @FXML
    private Label displayCity;
    @FXML
    public void updateWeather(ActionEvent event) {
        String API_KEY = "8b46f4be558820768ca1bcf2feed0b90";
        String location = "Raleigh";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY + "&units=imperial";
        double temperature = 0;
        String city = null;
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            JSONObject jsonResponse = new JSONObject(result.toString());
            temperature = jsonResponse.getJSONObject("main").getDouble("temp");
            city = jsonResponse.getString("name");
            System.out.println(temperature+city);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        displayTemp.setText(String.valueOf(temperature));
        displayCity.setText(city);
    }
 }
