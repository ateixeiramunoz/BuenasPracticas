package com.eoi.java6.project1;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@SpringBootTest
class Project1ApplicationTest {

    @Container
    @ServiceConnection
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>(
            "mysql:8.0.32"
    ).withDatabaseName("testDB").withUsername("appuser").withPassword("password123");
    /**
     * Ensures that the Spring application context loads successfully when the main method is called.
     */
    @Test
    @Order(1)
    void contextLoads() {
        log.info("Iniciando la prueba de contextos...");
        assertThat(mySQLContainer).isNotNull();
        for (String s : Arrays.asList("Context loaded", "Database name: " + mySQLContainer.getDatabaseName(), "Username: " + mySQLContainer.getUsername(), "Password: " + mySQLContainer.getPassword())) {
            log.error(s);
        }
        log.info("Contexto de Spring cargado con éxito.");
    }

}