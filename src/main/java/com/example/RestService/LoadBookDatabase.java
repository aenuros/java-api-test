package com.example.RestService;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadBookDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadBookDatabase.class);

  @Bean
  CommandLineRunner initDatabase(BookRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Book("Jane Eyre", "historical", 100, new BigDecimal(12.00))));
      log.info("Preloading " + repository.save(new Book("The Bell Jar", "memoir", 200, new BigDecimal(10.00))));
      
    };
  }
}