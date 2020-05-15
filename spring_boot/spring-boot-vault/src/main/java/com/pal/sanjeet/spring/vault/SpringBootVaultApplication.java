
package com.pal.sanjeet.spring.vault;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(PalConfiguration.class)
public class SpringBootVaultApplication implements CommandLineRunner {

  private final PalConfiguration configuration;

  public SpringBootVaultApplication(PalConfiguration configuration) {
    this.configuration = configuration;
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringBootVaultApplication.class, args);
  }

  @Override
  public void run(String... args) {

    Logger logger = LoggerFactory.getLogger(SpringBootVaultApplication.class);

    
    logger.info("   sanjeet.username is {}", configuration.getUsername());
    logger.info("   sanjeet.password is {}", configuration.getPassword());
  }
}
