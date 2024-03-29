package com.twcch.springbootjdbcmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.twcch.springbootjdbcmall.model.Product;
import com.twcch.springbootjdbcmall.service.ProductServie;

@RestController
public class ProductController {

	@Autowired
	private ProductServie productServie;

	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {

		Product product = productServie.getProductById(productId);

		if (product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(product);

	}

}
