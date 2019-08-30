package com.lojal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity//(name = "products_model")
public class ProductsModel {
	
	
	
	private Long id_product;
	private String brand;
	private String madein;
	private double price;
	private String name;
	
	public ProductsModel() {
		
	}

	protected ProductsModel(Long id_product, String brand, String madein, double price, String name) {
		super();
		this.id_product = id_product;
		this.brand = brand;
		this.madein = madein;
		this.price = price;
		this.name = name;
	}
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId_product() {
		return id_product;
	}

	public void setId_product(Long id_product) {
		this.id_product = id_product;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMadein() {
		return madein;
	}

	public void setMadein(String madein) {
		this.madein = madein;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
