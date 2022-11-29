package com.lincentpega.alfatestassignment.configuration;

import com.lincentpega.alfatestassignment.repository.BoxRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(BoxRepository boxRepository) {
        return args -> {

        };
    }
}
