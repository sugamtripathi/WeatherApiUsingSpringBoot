package rapidapi.weather.api;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import feign.RequestInterceptor;
import rapidapi.weather.api.client.ApiConfiguration;
import rapidapi.weather.api.client.RapidWeatherApiClient;



@SpringBootApplication
@EnableCaching
@EnableFeignClients(clients = {RapidWeatherApiClient.class})
//@ComponentScan(basePackages = "rapidapi.weather.*")
public class WeatherApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApiApplication.class, args);
	}
	
	

}
