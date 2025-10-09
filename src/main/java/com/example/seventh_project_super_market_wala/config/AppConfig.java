package com.example.seventh_project_super_market_wala.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

}
