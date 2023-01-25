package com.drawBoard.drawBoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DrawBoardApplication {

  public static void main(String[] args) {
		SpringApplication.run(DrawBoardApplication.class, args);
	}

  @GetMapping("/healthcheck")
  public String healthCheck() {
    return "Ok";
  }


  // @Bean
  // public WebMvcConfigurer corsConfigurer() {
  //     return new WebMvcConfigurer() {
  //         @Override
  //         public void addCorsMappings(CorsRegistry registry) {
  //             registry.addMapping("/**").allowCredentials(true).allowedOrigins("*").allowedMethods("*");
  //         }
  //     };
  // }

}
