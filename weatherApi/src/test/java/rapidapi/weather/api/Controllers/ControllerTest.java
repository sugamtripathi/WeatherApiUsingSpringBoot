package rapidapi.weather.api.Controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import nonapi.io.github.classgraph.utils.Assert;
import rapidapi.weather.api.client.RapidWeatherApiClient;
import rapidapi.weather.api.controller.Controller;
import rapidapi.weather.api.dto.ApiStatus;
import rapidapi.weather.api.dto.ForecastSummaryResponse;

@SpringBootTest
public class ControllerTest {
	
	@Mock
    private RapidWeatherApiClient rapidApiMock;

    @InjectMocks
    private Controller controller;

    @Test
    public void testGetApiStatus() {
        ApiStatus expectedStatus = new ApiStatus();
        expectedStatus.setStatus("OK");

        Mockito.when(rapidApiMock.getStatus()).thenReturn(expectedStatus);

        ApiStatus actualStatus = controller.getApiStatus();

        assertEquals(actualStatus, expectedStatus);
    }

    @Test
    public void testGetForecastSummaryByLocationName() {
        String locationName = "London";
        ForecastSummaryResponse expectedResponse = new ForecastSummaryResponse();
        // set expected response properties here

        Mockito.when(rapidApiMock.getForecastSummaryByLocationName(locationName)).thenReturn(expectedResponse);

        ResponseEntity<ForecastSummaryResponse> actualResponseEntity = controller.getForecastSummaryByLocationName(locationName);
        ForecastSummaryResponse actualResponse = actualResponseEntity.getBody();

        assertEquals(HttpStatus.OK, actualResponseEntity.getStatusCode());
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testGetHourlyForecastByLocationName() {
        String locationName = "New York";
        ForecastSummaryResponse expectedResponse = new ForecastSummaryResponse();
        // set expected response properties here

        Mockito.when(rapidApiMock.getForecastHourlyByLocationName(locationName)).thenReturn(expectedResponse);

        ResponseEntity<ForecastSummaryResponse> actualResponseEntity = controller.getHourlyForecastByLocationName(locationName);
        ForecastSummaryResponse actualResponse = actualResponseEntity.getBody();

        assertEquals(HttpStatus.OK, actualResponseEntity.getStatusCode());
        assertEquals(expectedResponse, actualResponse);
    }
	

}
