package rapidapi.weather.api.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import rapidapi.weather.api.dto.ApiStatus;
import rapidapi.weather.api.dto.ForeCast;
import rapidapi.weather.api.dto.ForecastSummaryResponse;

@SpringBootTest
class RapidWeatherApiClientTest {

	@Mock
    private RapidWeatherApiClient rapidWeatherApiClient;

    @Test
    public void testGetStatus() {
        ApiStatus expectedStatus = new ApiStatus();
        expectedStatus.setStatus("OK");

        when(rapidWeatherApiClient.getStatus()).thenReturn(expectedStatus);

        ApiStatus actualStatus = rapidWeatherApiClient.getStatus();

        verify(rapidWeatherApiClient).getStatus();
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    public void testGetForecastSummaryByLocationName() {
        ForecastSummaryResponse expectedResponse = new ForecastSummaryResponse();
        expectedResponse.setForecast(new ForeCast());

        String locationName = "Berlin";
        when(rapidWeatherApiClient.getForecastSummaryByLocationName(locationName)).thenReturn(expectedResponse);

        ForecastSummaryResponse actualResponse = rapidWeatherApiClient.getForecastSummaryByLocationName(locationName);

        verify(rapidWeatherApiClient).getForecastSummaryByLocationName(locationName);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testGetForecastHourlyByLocationName() {
        ForecastSummaryResponse expectedResponse = new ForecastSummaryResponse();
        expectedResponse.setForecast(new ForeCast());

        String locationName = "Berilin";
        when(rapidWeatherApiClient.getForecastHourlyByLocationName(locationName)).thenReturn(expectedResponse);

        ForecastSummaryResponse actualResponse = rapidWeatherApiClient.getForecastHourlyByLocationName(locationName);

        verify(rapidWeatherApiClient).getForecastHourlyByLocationName(locationName);
        assertEquals(expectedResponse, actualResponse);
    }

}
