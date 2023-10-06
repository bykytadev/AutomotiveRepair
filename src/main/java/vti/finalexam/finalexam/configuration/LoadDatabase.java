package vti.finalexam.finalexam.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vti.finalexam.finalexam.repository.CarRepository;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CarRepository repository) {

        return args -> {
            log.info("Preloading " + repository.findAll());
        };
    }
}
