package com.oneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oneToMany.entity.Product;
import com.oneToMany.entity.Customer;
import com.oneToMany.repository.CustomerRepository;

@SpringBootApplication
public class SpringbootHibernateOneManyMappingApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHibernateOneManyMappingApplication.class, args);
    }

    @Autowired
    private CustomerRepository postRepository;

    @Override
    public void run(String...args) throws Exception {

        Customer customer = new Customer("Cust 1", "1231241231");

        Product prod1 = new Product("Prod 1", "description for prod-1");
        Product prod2 = new Product("Prod 1", "description for prod-2");
        Product prod3 = new Product("Prod 1", "description for prod-3");

        customer.getProduct().add(prod1);
        customer.getProduct().add(prod2);
        customer.getProduct().add(prod3);

        this.postRepository.save(customer);
    }
}