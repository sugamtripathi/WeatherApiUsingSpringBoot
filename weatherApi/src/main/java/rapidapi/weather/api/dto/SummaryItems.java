package rapidapi.weather.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               
@AllArgsConstructor 
@NoArgsConstructor  
public class SummaryItems {
		String date;
		String dateWithTimezone;
		int freshSnow;
		int snowHeight;
		int sunHours;
		int rainHours;
		Weather weather;
		Prec prec;
		Temperature temperature;
		Wind wind;
		WindChills windchill;
		SnowLine snowLine;
		Astronomy astronomy;

}
