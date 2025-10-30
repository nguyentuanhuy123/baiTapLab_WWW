package iuh.fit.se.lab08_bai1_3_fe.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
	
	@Bean
	RestClient restClient() {
		return RestClient.builder().build();
	}
}
