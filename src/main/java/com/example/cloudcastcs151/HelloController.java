package com.example.cloudcastcs151;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class HelloController {
    @FXML
    private Label displayTemp;
    @FXML
    private TextField searchCity;
    @FXML
    private Button submitCity;
    private static final String API_ENDPOINT = "https://www.metaweather.com/api/location/";
    private static final String CITY_CODE = "2459115";

    @FXML
    public void displayWeather(ActionEvent event) {
        try {
            URL url = new URL(API_ENDPOINT + CITY_CODE + "/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            double temperature = 0.0; // Extract the actual temperature value
            displayTemp.setText("Temperature in New York City: " + temperature + "°C");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
