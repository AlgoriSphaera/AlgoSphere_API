package com.sj.algosphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@SpringBootApplication
public class AlgosphereApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgosphereApplication.class, args);
	}

	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> {
            web.ignoring().requestMatchers("/**");
        };
    }

}
