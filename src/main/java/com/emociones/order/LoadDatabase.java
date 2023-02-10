package com.emociones.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY", Locale.ENGLISH);

    @Bean
    CommandLineRunner initDatabase(com.emociones.order.EmployeeRepository employeeRepository, OrderRepository orderRepository) {

        return args -> {
            employeeRepository.save(new Employee("Bilbo", "Baggings", "6141111111", "bilbo@theshire.com"));
            employeeRepository.save(new Employee("Frodo", "Baggins", "6142222222", "frodo@theshire.com"));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));


            orderRepository.save(new Order(LocalDate.parse("15/12/2023", formatter), LocalDate.parse("16/12/2023", formatter), 3, "6145029654", OrderStatus.COMPLETED));
            orderRepository.save(new Order(LocalDate.parse("11/01/2024", formatter), LocalDate.parse("12/01/2024", formatter), 2, "6145142538", OrderStatus.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });

        };
    }
}