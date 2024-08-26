package org.example.springmvc.services.bai10;

import org.example.springmvc.model.bai10.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);
}