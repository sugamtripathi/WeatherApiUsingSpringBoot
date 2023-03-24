package rapidapi.weather.api.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import rapidapi.weather.api.service.impl.UserAction;

@Component
public class AuthenticationManagerWeatherApi implements AuthenticationManager {

	private  UserAction userAction;
	
	@Autowired
	WeatherApiPasswordEncoder passwordEncoder;
	
	@Autowired
	WeatherApiAuthenticationProvider authenticationProvider;
	
	public AuthenticationManagerWeatherApi(UserAction userDetailsService) {
        this.userAction = userAction;
    }
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		 	String username = authentication.getName();
	        String password = authentication.getCredentials().toString();

	        
	        
	        UserDetails userDetails = userAction.loadUserByUsername(username);
	        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
	            throw new BadCredentialsException("Incorrect password");
	        }

	        UsernamePasswordAuthenticationToken token =
	                new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
	        return authenticationProvider.authenticate(token);

	       
	} 

}
