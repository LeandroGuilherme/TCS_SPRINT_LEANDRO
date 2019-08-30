package com.lojal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojal.model.ProductsModel;
import com.lojal.repository.ProductsRepository;

@Service
public class ProductsService {
	@Autowired
	private ProductsRepository repo;
	
	public List<ProductsModel> findAll(){
		return repo.findAll();
	}
	
	public Optional<ProductsModel> findOne(Long id_products) {
		return repo.findById(id_products);
	}
	
	public ProductsModel save(ProductsModel product) {
		return repo.saveAndFlush(product);
	}
	
	public void delete(Long id_products) {
		repo.deleteById(id_products);
	}
}
