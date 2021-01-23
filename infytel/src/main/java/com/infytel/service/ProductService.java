package com.infytel.service;

import com.infytel.dto.Product;
import com.infytel.exceptions.NoSuchProductException;
import com.infytel.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public String addProduct(Product product) {
        productRepository.addProduct(product);
        return "Product " + product.getName() + " added Successfully";
    }

    public List<Product> fetchProduct() {
        return productRepository.fetchProduct();
    }

    public List<Product> getProducts(String productName) {
        return productRepository.getProducts(productName);
    }

    public List<Product> getProducts(String productName, String productVendor) {
        return productRepository.getProducts(productName,productVendor);
    }

    public List<Product> getProducts3(List<String> vendorList) {
        return productRepository.getProducts3(vendorList);
    }

    public String deleteProduct(int productId) throws NoSuchProductException {
        return productRepository.deleteProduct( productId);
    }
}
