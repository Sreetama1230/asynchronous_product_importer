package com.asynchproductimp.impl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asynchproductimp.impl.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
