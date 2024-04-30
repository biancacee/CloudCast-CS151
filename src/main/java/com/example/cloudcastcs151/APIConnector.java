package com.example.cloudcastcs151;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class APIConnector {
    @FXML
    private Pane home;
    @FXML
    private Button submitCity;
    @FXML
    private TextField searchCity;
    @FXML
    private Label displayTemp;
    @FXML
    private Label displayCity;
    @FXML
    private ImageView weatherImage;
    @FXML
    private Label displayHumidity;
    @FXML
    private Label displaySunrise;
    @FXML
    private Label displaySunset;
    @FXML
    private Label displayWindSpeed;
    @FXML
    private Label displayWindGust;
    @FXML
    private Label displayWindDegree;
    @FXML
    private Label displayRain;
    @FXML
    public void updateWeather(ActionEvent event) {
        String API_KEY = "e5f47ba96bff191a635b0a694812890a";
        Scanner scanner = new Scanner(System.in);
        String location = searchCity.getText();
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY + "&units=imperial";
        double temperature = 0;
        String city = null;
        String icon = null;
        String iconCode = null;
        Integer humidity = null;
        String sunrise = null;
        String sunset = null;
        String windSpeed = null;
        String windGust = null;
        String windDegree = null;
        Double rain = 0.0;
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
            humidity = jsonResponse.getJSONObject("main").getInt("humidity");
            city = jsonResponse.getString("name");
            sunrise = jsonResponse.getJSONObject("main").getString("sunrise");
            sunset = jsonResponse.getJSONObject("main").getString("sunset");
            windSpeed = jsonResponse.getJSONObject("main").getString("wind_speed");
            windGust = jsonResponse.getJSONObject("main").getString("wind_gust");
            windDegree = jsonResponse.getJSONObject("main").getString("wind_deg");
            rain = jsonResponse.getJSONObject("main").getDouble("rain");
            System.out.println(temperature + city+humidity+sunrise+sunset);
            JSONArray weatherArray = jsonResponse.getJSONArray("weather");
            if (weatherArray.length() > 0) {
                JSONObject weatherObject = weatherArray.getJSONObject(0);
                iconCode = weatherObject.getString("icon");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        displayTemp.setText(String.valueOf(temperature));
        displayCity.setText(city);
        displayHumidity.setText(String.valueOf(humidity));
        displaySunrise.setText(String.valueOf(sunrise));
        displaySunset.setText(String.valueOf(sunset));
        displayWindSpeed.setText(String.valueOf(windSpeed));
        displayWindGust.setText(String.valueOf(windGust));
        displayWindDegree.setText(String.valueOf(windDegree));
        displayRain.setText(String.valueOf(rain));

        if (iconCode != null)
        {
            String iconURL = "http://openweathermap.org/img/wn/"+iconCode+ ".png";
            ImageView iconImage = new ImageView(iconURL);
            weatherImage.setImage(iconImage.getImage());
        }

    }
 }
