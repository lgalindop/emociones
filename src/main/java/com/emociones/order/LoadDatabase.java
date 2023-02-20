package com.emociones.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository, EmployeeRepository employeeRepository, OrderRepository orderRepository) {

        return args -> {
/*
            customerRepository.save(new Customer("Luis", "Galindo", "6145029654", "lgalindop@gmail.com"));
            customerRepository.save(new Customer("Juan", "Perez", "6141111111", "juanperez@gmail.com"));

            customerRepository.findAll().forEach(customer -> log.info("Preloaded " + customer));

            employeeRepository.save(new Employee("Luis", "Galindo", "Manuel", "Parra", "6145029654", "lgalindop@gmail.com"));
            employeeRepository.save(new Employee("Adriana", "Romero", null, "Ornelas", "6145142538", "adiiromeroo@gmail.com"));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));
*/


            orderRepository.save(new Order(LocalDate.parse("2023-12-15"), LocalDate.parse("2023-12-16"), 3, OrderStatus.COMPLETED, "6145029654"));
            orderRepository.save(new Order(LocalDate.parse("2024-01-11"), LocalDate.parse("2024-01-12"), 2, OrderStatus.IN_PROGRESS, "6141111111"));

            orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));

        };
    }
}
