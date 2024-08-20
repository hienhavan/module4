package org.example.springmvc.services.bai6_7;


import org.example.springmvc.model.bai6_7.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void remove(int id);
}