package rapidapi.weather.api.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import rapidapi.weather.api.dto.User;

@Service
public class UserAction implements UserDetailsService {
		Map<String,String> users=new HashMap();
		
		public UserAction() {
			users.put("sugam", "password");
		}
		
	
	public boolean isUser(String user,String password) {
		
		return user.equals("user")&&password.equals("password");
			
	}
	
	
	public UserDetails loadUserByUsername(String userName) {
		return new org.springframework.security.core.userdetails.User(userName,users.get(userName),Collections.emptyList());
	}
	
	
	
}
