package rapidapi.weather.api.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.Data;

@Data
@Configuration
public class ApiConfiguration  {

	
	 
	 @Value("${application.header.key}")
     private String key;
	 
	 

	 @Bean
	    public RequestInterceptor requestInterceptor() {
	        return new RequestInterceptor() {
	            @Override
	            public void apply(RequestTemplate template) {
	                template.header("x-rapidapi-key", key);
	                template.header("x-rapidapi-host", "forecast9.p.rapidapi.com");
	            }
	        };
	    }

}
