package com.lojal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojal.model.ProductsModel;

public interface ProductsRepository extends JpaRepository<ProductsModel, Long> {

}

