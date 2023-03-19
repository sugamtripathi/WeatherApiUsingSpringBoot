package rapidapi.weather.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Astronomy {
	
		String dawn;
		String sunrise;
		String suntransit;
		String sunset;
		String dusk;
		String moonrise;
		String moontransit;
		String moonset;
		int moonphase;
		int moonzodiac;

}
