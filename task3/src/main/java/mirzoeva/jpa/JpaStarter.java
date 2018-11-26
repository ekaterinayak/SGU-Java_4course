package mirzoeva.jpa;

import mirzoeva.jpa.model.Customer;
import mirzoeva.jpa.model.CustomerGroup;
import mirzoeva.jpa.repository.CustomerGroupRepository;
import mirzoeva.jpa.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaStarter {

    private static final Logger log = LoggerFactory.getLogger(JpaStarter.class);

    public static void main(String[] args) {
        SpringApplication.run(JpaStarter.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            CustomerRepository customerRepository = ctx.getBean(CustomerRepository.class);
            CustomerGroupRepository customerGroupRepository = ctx.getBean(CustomerGroupRepository.class);

            customerGroupRepository.save(new CustomerGroup("group1"));
            customerGroupRepository.save(new CustomerGroup("group2"));
            customerGroupRepository.save(new CustomerGroup("group3"));

            // save a couple of customers
            customerRepository.save(new Customer("Jack", "Bauer"));
            customerRepository.save(new Customer("Chloe", "O'Brian"));
            customerRepository.save(new Customer("Kim", "Bauer"));
            customerRepository.save(new Customer("David", "Palmer"));
            customerRepository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            customerRepository.findAll().forEach(customer -> log.info(customer.toString()));
            log.info("");

            // fetch an individual customer by ID
            customerRepository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            customerRepository.findByLastName("Bauer").forEach(bauer -> log.info(bauer.toString()));
            log.info("");

            Customer customer1 = customerRepository.findByLastName("O'Brian").get(0);
            Customer customer2 = customerRepository.findByLastName("Palmer").get(0);

            CustomerGroup group1 = customerGroupRepository.findByName("group1").get(0);
            CustomerGroup group2 = customerGroupRepository.findByName("group2").get(0);

            customer1.getGroups().add(group1);
            customer1.getGroups().add(group2);
            customerRepository.save(customer1);

            customer2.getGroups().add(group1);
            customerRepository.save(customer2);

            log.info("Customers & groups info:");
            log.info("--------------------------------------------");
            customerRepository.findAll().forEach(customer -> log.info(customer.toString()));
            customerGroupRepository.findAll().forEach(customerGroup -> log.info(customerGroup.toString()));

            log.info("");
        };
    }
}
