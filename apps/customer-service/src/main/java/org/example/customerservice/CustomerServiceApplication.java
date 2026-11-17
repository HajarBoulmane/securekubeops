package org.example.customerservice;

import org.example.customerservice.entities.Customer;
import org.example.customerservice.repositories.CustomerRepository;
import org.example.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerService customerService,
                                        CustomerRepository customerRepository) {
        return args -> {
            if (customerRepository.count() == 0) {
                List<String> names = List.of("Mohamed", "Imane", "Yassine");
                names.forEach(name -> customerService.saveCustomer(
                        Customer.builder().name(name).email(name + "@gmail.com").build()));
            }
        };
    }
}