package api.innocv;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@ComponentScan({ "api.innocv.controller", "api.innocv.service"})
@EntityScan("api.innocv.entities")
@EnableJpaRepositories({"api.innocv.dao"})
@EnableAsync
public class ApiInnoCvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiInnoCvApplication.class, args);
	}
	
	@Bean(name="userAsyncThreadExecutor")
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setMaxPoolSize(100);
		executor.setThreadNamePrefix("API REST ASYNC-");
		executor.initialize();
		return executor;
		
	}

}
