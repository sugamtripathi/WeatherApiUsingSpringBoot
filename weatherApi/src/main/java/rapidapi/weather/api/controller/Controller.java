package rapidapi.weather.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rapidapi.weather.api.Security.JwtUtil;
import rapidapi.weather.api.client.RapidWeatherApiClient;
import rapidapi.weather.api.dto.ApiStatus;
import rapidapi.weather.api.dto.ForecastSummaryResponse;
import rapidapi.weather.api.dto.StoryDto;

//@RequestMapping("/api/v01")
@RestController
public class Controller {

	
	
	 
	    @GetMapping("/test")
	    public String test() {
	    	return "health OK";
	    }
	    
	   
   
	    @Autowired
	    private RapidWeatherApiClient rapidApi;

	    
	    @GetMapping("/getStatus/")
	    public ApiStatus getApiStatus() {
//	   
	    	
	    	return rapidApi.getStatus();
	    	
	    }
	    
	    
	    @GetMapping("/summary/")
	    public ResponseEntity<ForecastSummaryResponse> getForecastSummaryByLocationName
	    (@RequestParam String locationName) {
	    	 ForecastSummaryResponse response= rapidApi.getForecastSummaryByLocationName(locationName);
	        return ResponseEntity.ok(response);
	       
	    }
	    
	    @GetMapping("/hourly/")
	    public ResponseEntity<ForecastSummaryResponse> getHourlyForecastByLocationName(@RequestParam String locationName) {
	        ForecastSummaryResponse response = rapidApi.getForecastHourlyByLocationName(locationName);
	        return ResponseEntity.ok(response); 
	       }
	    
	  
	    

}

//JWT 
