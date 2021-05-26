package api.innocv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "api.innocv.controller", "api.innocv.service"})
@EntityScan("api.innocv.entities")
@EnableJpaRepositories({"api.innocv.dao"})
public class ApiInnoCvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiInnoCvApplication.class, args);
	}

}
