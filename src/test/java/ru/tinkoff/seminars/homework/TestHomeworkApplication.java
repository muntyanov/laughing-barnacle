package ru.tinkoff.seminars.homework;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.WaitAllStrategy;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import javax.sql.DataSource;

@SpringBootTest
@Testcontainers
public class TestHomeworkApplication {

    @Container
    private static PostgreSQLContainer container = new PostgreSQLContainer<>(
			DockerImageName.parse("postgres:latest")
	).withNetwork(Network.SHARED).waitingFor(new WaitAllStrategy())
            .withReuse(true);


    @Test
    public void test(){
        assert true;
    }

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
	}

    public static void main(String[] args) {
        SpringApplication.from(HomeworkApplication::main).with(TestHomeworkApplication.class).run(args);
    }
}
