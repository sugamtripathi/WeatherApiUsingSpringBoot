package rapidapi.weather.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wind {

	String unit;
	String direction;
	String text;
	int avg;
	int min;
	int max;
	Boolean significationWind;
	Gusts gusts;
}
