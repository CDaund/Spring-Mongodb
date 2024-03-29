package com.ltimindtree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@EnableJpaRepositories
public class SpringbootMongodbAtlasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbAtlasApplication.class, args);
	}

}
