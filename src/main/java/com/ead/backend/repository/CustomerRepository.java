package com.ead.backend.repository;

import com.ead.backend.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query(value = "SELECT * FROM Customer c WHERE id=?1", nativeQuery = true)
    Customer testingFunc(Integer id);

    Customer findCustomerById(Integer id);
}
