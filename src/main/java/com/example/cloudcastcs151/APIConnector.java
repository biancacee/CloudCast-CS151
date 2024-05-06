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
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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
    private Label displayFeelsLike;
    @FXML
    public void updateWeather(ActionEvent event) throws UnsupportedEncodingException {
        String API_KEY = "1612512dcbfc472803d83860453ee9b1";

        Scanner scanner = new Scanner(System.in);
        String location = searchCity.getText();
        String encodedLocation = URLEncoder.encode(location, "UTF-8");

        String urlString = "https://api.openweathermap.org/data/2.5/weather?q="+encodedLocation+"&appid="+ API_KEY +"&units=imperial";
        double temperature = 0;
        double feels_like = 0;
        String city = null;
        String icon = null;
        String iconCode = null;
        Integer humidity = null;
        int sunrise = 0;
        int sunset = 0;
        double windSpeed = 0.0;
        double windGust = 0.0;
        int windDegree = 0;
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
            feels_like = jsonResponse.getJSONObject("main").getDouble("feels_like");
            humidity = jsonResponse.getJSONObject("main").getInt("humidity");
            city = jsonResponse.getString("name");
            sunrise = jsonResponse.getJSONObject("sys").getInt("sunrise");
            sunset = jsonResponse.getJSONObject("sys").getInt("sunset");
            windSpeed = jsonResponse.getJSONObject("wind").getDouble("speed");
           // windGust = jsonResponse.getJSONObject("wind").getDouble("gust");
            windDegree = jsonResponse.getJSONObject("wind").getInt("deg");
       //     rain = jsonResponse.getJSONObject("rain").getDouble("1h");
            System.out.println(temperature + city+humidity);
            JSONArray weatherArray = jsonResponse.getJSONArray("weather");
            if (weatherArray.length() > 0) {
                JSONObject weatherObject = weatherArray.getJSONObject(0);
                iconCode = weatherObject.getString("icon");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        displayTemp.setText("Temperature: "+String.valueOf(temperature));
        displayFeelsLike.setText("Feels Like: "+String.valueOf(feels_like));
        displayCity.setText("City: "+ city);
        displayHumidity.setText("Humidity: "+String.valueOf(humidity));
        displaySunrise.setText("Sunrise: "+String.valueOf(sunrise));
        displaySunset.setText("Sunset: "+String.valueOf(sunset));
        displayWindSpeed.setText("Wind Speed: "+String.valueOf(windSpeed));
      //  displayWindGust.setText(String.valueOf(windGust));
        displayWindDegree.setText("Wind Degree: "+String.valueOf(windDegree));
        //displayRain.setText(String.valueOf(rain));

        if (iconCode != null)
        {
            String iconURL = "http://openweathermap.org/img/wn/"+iconCode+ ".png";
            ImageView iconImage = new ImageView(iconURL);
            weatherImage.setImage(iconImage.getImage());
        }

    }
 }
