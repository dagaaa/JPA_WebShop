package com.daga.repository;

import com.daga.model.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findCustomerByFirstNameAndLastNameAndCity(String firstName, String lastName, String city);

}
