package com.example.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.postgresql.model.Product;

@Repository
public interface ProductRespository extends JpaRepository<Product, Long> {

}
