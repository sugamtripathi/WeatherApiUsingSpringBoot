#Weather API using RapidAPI
This is a SpringBoot Java application that integrates with the Weather API from RapidAPI to provide two RESTful APIs that return weather forecast data for any city. The APIs use header-based authentication with a random client ID and secret.

#Authentication
Header-based authentication is used to secure the APIs. To access the APIs, you must provide a key header. You can obtain these by signing up for a RapidAPI account and subscribing to the Weather API. Once you have your keys, you can use them to authenticate your API calls.
https://rapidapi.com/wettercom-wettercom-default/api/forecast9

#APIs
The following APIs are provided:

Get the Weather forecast summary of any city
This API returns a summary of the weather forecast for a given city.

#Endpoint
GET /summary

#Query Parameters
locationName: the name of the city for which to retrieve the weather forecast data.
Response
The API returns a JSON object with the following fields:

city: the name of the city for which the data was retrieved
timezone: the timezone of the city
latitude: the latitude of the city
longitude: the longitude of the city
forecast: an array of objects that represent the forecast for the next several days. Each object contains the following fields:
date: the date of the forecast
maxTemperature: the maximum temperature for the day
minTemperature: the minimum temperature for the day
precipitationProbability: the probability of precipitation for the day
sunriseTime: the time of sunrise for the day
sunsetTime: the time of sunset for the day
Get hourly Weather forecast details of any city
This API returns detailed weather forecast data for a given city.

#Endpoint
GET /hourly

#Query Parameters
locationName: the name of the city for which to retrieve the weather forecast data.
Response
The API returns a JSON object with the following fields:

city: the name of the city for which the data was retrieved
timezone: the timezone of the city
latitude: the latitude of the city
longitude: the longitude of the city
forecast: an array of objects that represent the forecast for the next several hours. Each object contains the following fields:
time: the time of the forecast
temperature: the temperature at that time
precipitationProbability: the probability of precipitation at that time
wind: an object representing the wind conditions at that time, containing the following fields:
speed: the speed of the wind
direction: the direction of the wind
Technologies
This project uses the following technologies:

SpringBoot
OpenFeign
Mockito
JUnit

#Usage
To run the application, you can use the following command:
mvn spring-boot:run



bash
Copy code
mvn spring-boot:run


Once the application is running, you can access the APIs by making HTTP requests to the endpoints described above. You can use any HTTP client, such as curl or a web browser. You must include the client-id and client-secret headers in your requests to authenticate.

#Contributing
If you'd like to contribute to this project, feel free to submit a pull request or open an issue. All contributions are welcome!
