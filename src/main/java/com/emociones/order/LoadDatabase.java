package com.emociones.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    @Bean
    CommandLineRunner initDatabase(com.emociones.order.EmployeeRepository employeeRepository, OrderRepository orderRepository) {

        return args -> {
            employeeRepository.save(new Employee("Bilbo", "Baggings", "6141111111", "bilbo@theshire.com"));
            employeeRepository.save(new Employee("Frodo", "Baggins", "6142222222", "frodo@theshire.com"));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));


            orderRepository.save(new Order(LocalDate.parse("2023-12-15", formatter), LocalDate.parse("2023-12-16", formatter), 3, "6145029654", OrderStatus.COMPLETED));
            orderRepository.save(new Order(LocalDate.parse("2024-01-11", formatter), LocalDate.parse("2024-01-12", formatter), 2, "6145142538", OrderStatus.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });

        };
    }
}