package rapidapi.weather.api.Security;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class WeatherApiPasswordEncoder  implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return String.valueOf(rawPassword.hashCode());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
	}

}
