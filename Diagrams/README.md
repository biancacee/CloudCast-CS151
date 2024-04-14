### Use Case Diagram [Diagrams/WeatherUML.drawio.png]()

- The actors of this use case diagram represent the users and their interactions with the system.
  The two actors are the system and a user.
- The user can view weather information, search by city, state, or zipcode, and save their preferred location.
- Users can create an account, log into their account, and delete their account.
- The system will use a weather API to provide the user with accurate weather information.
- Alerts by the system will notify users when their is a weather warning in near their location.


### Class Diagram [Diagrams/CS-151-ClassDiagram.drawio.png]()
- There are a total of 6 classes described in the class diagram.
- Each class has its corresponding attributes and methods that belong to the class itself.
- The user class identifies each user with a unique user ID that will be used to get the users weather preferences.
- Each User has a userID and password, and is given Weather Forecast
- Weather consists of current and future Forecasts
- Current and future forecasts consists of an enumerated forecast.

### State Diagram [Diagrams/state_diagram.jpg]()

- The state diagram demonstrates the different states the user interacts with when using the application.
- Users log into the account and are presented with their preferred location for weather information.
- The user can switch between locations by saving and deleting their selections.

### Sequence Diagram [Diagrams/cs151Proj_SequenceDiagram.drawio.png]()

- The sequence diagram shows the interactions between the user, system, and the weather API.
- Users log into the account and request data from the weather API.
- The API responds and the information is displayed.
- Users can search for cities and request weather information for that location.
- If the location does not exist the user will be notified.