package com.pal.sanjeet.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;

@SpringBootApplication
public class SpringBootWeatherAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWeatherAppApplication.class, args);
	}

}


@Controller
class PalController{

	@RequestMapping("/home")
	public String get_location() {
		return "home";
	}
}
