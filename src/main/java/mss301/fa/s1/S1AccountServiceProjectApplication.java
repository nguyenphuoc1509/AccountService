package mss301.fa.s1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"mss301.fa.s1.config", "mss301.fa.s1.service", "mss301.fa.s1.controller"})
@EnableJpaRepositories(basePackages = {"mss301.fa.s1.repository"})
@EntityScan(basePackages = {"mss301.fa.s1.model"})
public class S1AccountServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(S1AccountServiceProjectApplication.class, args);
	}

}
