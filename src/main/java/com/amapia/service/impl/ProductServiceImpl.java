package com.amapia.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amapia.entity.Amap;
import com.amapia.entity.Product;
import com.amapia.repository.ProductRepository;
import com.amapia.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product saveProduct(Product product, MultipartFile file) throws IOException {
		if (file != null && !file.isEmpty()) {
			product.setImageData(file.getBytes());
			product.setImageName(file.getOriginalFilename());
			product.setImageType(file.getContentType());
		}	
		return productRepository.save(product);
	}

	@Override
	public List<Product> getProductsByProducerId(Long producerId) {
		return productRepository.findByProducerId(producerId);
	}

	@Override
	public List<Product> getActiveProducts() {
		return productRepository.findByIsActiveTrue();
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Optional<Product> existingProductOpt = productRepository.findById(id);
        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();
            existingProduct.setName(product.getName());
            existingProduct.setActive(product.isActive());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setStock(product.getStock());
            existingProduct.setProducer(product.getProducer());
            existingProduct.setImageData(product.getImageData());
            existingProduct.setImageName(product.getImageName());
            existingProduct.setImageType(product.getImageType());
            return productRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Product not found with ID: " + id);
        }
	}

	@Override
	public List<Product> getLastTwoProductsByAmap(Amap amap) {
	    List<Product> allProducts = productRepository.findTop2ByAmapOrderByIdDesc(amap);
	    return allProducts.stream().limit(2).collect(Collectors.toList());
	}



	@Override
	public List<Product> getProductsByAmap(Amap amap) {
		return productRepository.findProductsByAmap(amap);
	}


}
