package rapidapi.weather.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prec {
	Float sum;
	int probability;
	int sumAsRain;
	int classs;

}
