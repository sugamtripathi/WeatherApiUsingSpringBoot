package rapidapi.weather.api.Security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import rapidapi.weather.api.dto.User;

@Component
public class JwtUtil {

	@Value("${weather.app.jwtSecret}")
	private String secret;
	
	@Value("${weather.app.jwtExpirationMs}")
	Long Validity;
	
	private Key getSecretKey() {
	       return Keys.hmacShaKeyFor(secret.getBytes());
	   }
	
	
	public String generateToken(UserDetails userDetails) {
	       Map<String, Object> claims = new HashMap<>();
	       return Jwts.builder()
	               .setClaims(claims)
	               .setSubject(userDetails.getUsername())
	               .setIssuedAt(new Date(System.currentTimeMillis()))
	               .setExpiration(new Date(System.currentTimeMillis() + Validity * 1000))
	               .signWith(getSecretKey())
	               .compact();
	   }
	
	private Claims getAllClaimsFromToken(String token) {
	       return Jwts.parserBuilder().setSigningKey(getSecretKey()).build().parseClaimsJws(token).getBody();
	   }
	
	
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
	       final Claims claims = getAllClaimsFromToken(token);
	       return claimsResolver.apply(claims);
	   }
	
	
	public String getUsernameFromToken(String token) {
	       return getClaimFromToken(token, Claims::getSubject);
	   }
	
	public boolean validateToken(String token, UserDetails userDetails) {
	       final String username = getUsernameFromToken(token);
	       return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	       
	       
	   }
	
	
	
	 public Date getExpirationDateFromToken(String token) {
	       return getClaimFromToken(token, Claims::getExpiration);
	   }

	
	
	 private boolean isTokenExpired(String token) {
	       final Date expiration = getExpirationDateFromToken(token);
	       return expiration.before(new Date());
	   }
	
}
