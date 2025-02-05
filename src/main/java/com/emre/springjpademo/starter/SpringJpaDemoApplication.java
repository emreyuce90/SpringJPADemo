package com.emre.springjpademo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.emre.springjpademo"})
@EnableJpaRepositories(basePackages = {"com.emre.springjpademo"})
@EntityScan(basePackages = {"com.emre.springjpademo"})
@SpringBootApplication
public class SpringJpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaDemoApplication.class, args);
    }

}
