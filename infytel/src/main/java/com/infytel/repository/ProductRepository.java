package com.infytel.repository;

import com.infytel.dto.Product;
import com.infytel.exceptions.NoSuchProductException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private List<Product> products = null;

    @PostConstruct
    private void initializer() {
        Product product1 = new Product(21, "Cooker", "Prestige", 2000, 'Y');
        Product product2 = new Product(22, "Gas", "Prestige", 3000, 'Y');
        Product product3 = new Product(23, "Gas", "Prestige21", 3000, 'Y');
        products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> fetchProduct() {
        return products;
    }

    public List<Product> getProducts(String productName) {
        return products.stream().filter(x -> x.getName().equals(productName)).collect(Collectors.toList());
    }

    public List<Product> getProducts(String productName, String productVendor) {
        return products.stream()
                .filter(x -> x.getName().equals(productName) && x.getVendor().endsWith(productVendor))
                .collect(Collectors.toList());
    }

    public List<Product> getProducts3(List<String> vendorList) {
        List<Product> pr = new ArrayList<>();
        vendorList.forEach(
                vendor -> {
                    products.forEach(x -> {
                                if (x.getVendor().equals(vendor)) {
                                    pr.add(x);
                                }
                            }
                    );
                }
        );
        return pr;
    }

    public String deleteProduct(int productId) throws NoSuchProductException {
        Product pr = products.stream().filter(x -> x.getId() == productId).findFirst().
                orElseThrow(() -> new NoSuchProductException("Product not found:" + productId));
        products.remove(pr);
        return "product removed successfully :" + productId;
    }
}
