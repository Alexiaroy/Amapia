package com.amapia.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.amapia.entity.Amap;
import com.amapia.entity.Product;

public interface ProductService {
	List<Product> getAllProducts();
    List<Product> getActiveProducts();
    Product getProductById(Long id);
    Product saveProduct(Product product, MultipartFile file) throws IOException;
    List<Product> getProductsByProducerId(Long producerId);
    Product updateProduct(Long id, Product product);
    List<Product> getLastTwoProductsByAmap(Amap amap);
    List<Product> getProductsByAmap(Amap amap);
}
