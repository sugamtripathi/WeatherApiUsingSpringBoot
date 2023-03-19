package rapidapi.weather.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               
@AllArgsConstructor 
@NoArgsConstructor  
public class Location {
	String 	code;
	String 	name;
	String 	timezone;
	Coordinates coordinates;

}
