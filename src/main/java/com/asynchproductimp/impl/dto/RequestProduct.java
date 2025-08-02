package com.asynchproductimp.impl.dto;

import com.asynchproductimp.impl.entities.Product;

public class RequestProduct {
	private String price;

	private String name;

	private String company;

	private String location;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public RequestProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestProduct(String price, String name, String company, String location) {
		super();
		this.price = price;
		this.name = name;
		this.company = company;
		this.location = location;
	}

	public static Product toProduct(RequestProduct req) {
		Product product = new Product(req.getPrice(), req.getName(), req.getCompany(), req.getLocation());
		return product;
	}
}
