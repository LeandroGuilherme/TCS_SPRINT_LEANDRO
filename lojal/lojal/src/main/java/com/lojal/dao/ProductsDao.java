package com.lojal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lojal.model.ProductsModel;
import com.lojal.repository.ProductsRepository;



@Service
@Transactional
public class ProductsDao {
	

	@Autowired
	private ProductsRepository repo;
	
	public List<ProductsModel> listAll(){
		return repo.findAll();
	}
	
	public ProductsModel get(long id_product) {
		return repo.findById(id_product).get();
	}
	
	public void save(ProductsModel product) {
		repo.save(product);
	}
	
	public void delete(long id_product) {
		repo.deleteById(id_product);
	}
}
