# Cloud Cast
### PROBLEM TO SOLVE

We are hoping to address several issues relating to user access to accurate weather and temperature information that several weather apps currently face. We hope to solve the issue of the lack of accessibility by creating a weather app with a plethora of functionalities to display and predict accurate weather information as well as get rid of any inconsistencies in weather-predicting algorithms.

### PREVIOUS WORKS

Projects from classes include:
CMPE-131, CMPE-133, CMPE-157A

### ASSUMPTIONS/OPERATING ENVIRONMENTS/USAGE

We will be using JavaFX and Scene Builder to create this weather app. Additionally, we will obtain an existing API such as MetaWeather.  JSON will be used to retrieve weather application information and display it to the users.

With Maven we will need to add necessary dependencies for creating HTTP requests, including libraries such as the Apache HttpComponents library.

### SOLUTION
We hope to provide the best user experience in weather applications using an existing API to provide real-time weather forecasts.

### PLAN
- Decide which framework and database to use
- API integration with MetaWeather
- Create app architecture and design using SceneBuilder
- Use Agile development process
- Provide testing and quality assurance
- User registration and authentication
- Implementation of an alert system

### APPROACH
- Use JavaFX for GUI
- Integrate public API MetaWeather
- Use JSON to parse responses
- Create an appealing UI to incorporate our project



### FUNCTIONALITY
The functionality of this application relies on the implementation of an API to provide the end user with accurate weather information. This weather information includes, but is not limited to, current weather conditions and predictions of future weather conditions. The information will be presented in several ways including air temperature, humidity, wind, UV index, precipitation expectancy, and additional features that can enhance the user experience. Our goal is to provide accurate weather information for short-term and long-term forecasts. Search filters will give users options to search by city, state, or zipcode. Additionally, allowing users to create an account and save their preferred cities will help them access desired information faster. Users can delete their account but can continue to monitor the weather without saving preferences. Implementing the use of alerts to notify users of an upcoming storm, heatwave, or relevant information will give users the opportunity to prepare for the upcoming weather. We hope to provide users with a reliable and appealing weather source to stay updated and plan accordingly.


### OPERATIONS
End-user:
- Input and Change desired location for weather information using search criteria
- View and access weather information
- Input and view the desired time frame for weather information
- Access short-term, and long-term weather forecasts
- View sunrise and sunset times
- Customize Units and Preferences including degrees in Fahrenheit or Celsius
- View radar/satellite information
- Receive alerts and warnings
- Create an account to save preferred locations
- Delete account 