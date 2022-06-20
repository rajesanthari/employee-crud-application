package com.ranthari.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class AppConfiguration {

	
	/**
	 * Ref url: https://stackoverflow.com/questions/36968963/how-to-configure-cors-in-a-spring-boot-spring-security-application/37610988#37610988
	 * @return
	 */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
		//Reference: https://stackoverflow.com/questions/49333762/spring-security-cors-doesnt-work-for-http-put-method
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
		source.registerCorsConfiguration("/**", corsConfiguration);
		return source;
	}
	
}
