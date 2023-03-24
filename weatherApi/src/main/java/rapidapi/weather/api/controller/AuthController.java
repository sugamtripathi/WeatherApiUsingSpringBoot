package rapidapi.weather.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rapidapi.weather.api.Security.AuthenticationManagerWeatherApi;
import rapidapi.weather.api.Security.JwtUtil;
import rapidapi.weather.api.Security.RefreshTokenRequest;
import rapidapi.weather.api.dto.User;
import rapidapi.weather.api.response.AuthenticationResponse;
import rapidapi.weather.api.service.impl.UserAction;

@RestController
//@RequestMapping("/user")
public class AuthController {
	
		@Autowired
	    private AuthenticationManagerWeatherApi authenticationManager;

	    @Autowired
	    private UserAction userAction;

	    @Autowired
	    private JwtUtil jwtUtil;
	    

	   

	    @PostMapping("/authenticate")
	    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user) throws Exception {
	        try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	        } catch (Exception e) {
	        	
//	            throw new Exception("Incorrect username or password", e);
	            return ResponseEntity.ok(new String("Incorrect username or password"));
	        }

	        final UserDetails userDetails = userAction.loadUserByUsername(user.getUsername());
	        final String token = jwtUtil.generateToken(userDetails);

	        return ResponseEntity.ok(new AuthenticationResponse(token));
	    }
	    
	    
	    @PostMapping("/refresh")
	    public ResponseEntity<?> refreshAndGetAuthenticationToken(@RequestBody RefreshTokenRequest refreshTokenRequest) throws Exception {
	        final String token = refreshTokenRequest.getRefreshToken();
	        String username = null;
	        try {
	            username = jwtUtil.getUsernameFromToken(token);
	        } catch (Exception e) {
	            throw new Exception("Invalid refresh token", e);
	        }

	        final UserDetails userDetails = userAction.loadUserByUsername(username);

	        if (jwtUtil.validateToken(token, userDetails)) {
	            final String newToken = jwtUtil.generateToken(userDetails);
	            return ResponseEntity.ok(new AuthenticationResponse(newToken));
	        } else {
	            throw new Exception("Invalid refresh token");
	        }
	    }

}
