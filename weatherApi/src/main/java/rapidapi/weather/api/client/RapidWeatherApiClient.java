package rapidapi.weather.api.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import feign.HeaderMap;
import feign.Headers;
import lombok.Value;
import rapidapi.weather.api.dto.ApiStatus;
import rapidapi.weather.api.dto.ForecastSummaryResponse;
 



@Service
@FeignClient(name = "rapid-api-weather", url = "https://forecast9.p.rapidapi.com/")
public interface RapidWeatherApiClient {
	
	
	
		
	@GetMapping("status/")	
	ApiStatus getStatus();
	
	@GetMapping("rapidapi/forecast/{locationName}/summary/")
	ForecastSummaryResponse getForecastSummaryByLocationName(@RequestParam("locationName") String locationName);
	
	@GetMapping("rapidapi/forecast/{locationName}/hourly/")
	ForecastSummaryResponse getForecastHourlyByLocationName(@RequestParam("locationName") String locationName);
	
	
}
