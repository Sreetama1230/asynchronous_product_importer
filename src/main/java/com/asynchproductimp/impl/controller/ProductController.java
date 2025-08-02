package com.asynchproductimp.impl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asynchproductimp.impl.dto.RequestProduct;
import com.asynchproductimp.impl.entities.Product;
import com.asynchproductimp.impl.entities.Status;
import com.asynchproductimp.impl.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadProducts(@RequestBody List<RequestProduct> list) {

		List<Product> input = list.stream().map(l -> RequestProduct.toProduct(l)).toList();
		return new ResponseEntity<String>(service.uploadProducts(input), HttpStatus.CREATED);
	}

	@GetMapping("/status/{ticketId}")
	public ResponseEntity<String> getStatus(@PathVariable String ticketId) {
		Status s = service.getStatus(ticketId);
		return new ResponseEntity<String>(s.toString(), HttpStatus.OK);

	}

}
