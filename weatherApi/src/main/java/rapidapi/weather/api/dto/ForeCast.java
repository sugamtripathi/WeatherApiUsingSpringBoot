package rapidapi.weather.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForeCast {
	List<SummaryItems> items;
		String forecastDate;
		String nextUpdate;
		String source;
		String point;
		String fingerprint;
}
