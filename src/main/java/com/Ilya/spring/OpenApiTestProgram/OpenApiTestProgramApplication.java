package com.Ilya.spring.OpenApiTestProgram;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan("com.*")
@EnableJpaRepositories("com.*")
@ComponentScan(basePackages = { "com.*" })
@SpringBootApplication(scanBasePackages={"com.Ilya.spring.OpenApiTestProgram", "com.Ilya.spring.OpenApiTestProgram.dao"})
@OpenAPIDefinition(info = @Info(title = "Messages API", version = "2.0", description = "PostMethod testing with db table and flyway"))
public class OpenApiTestProgramApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenApiTestProgramApplication.class, args);
	}

}
