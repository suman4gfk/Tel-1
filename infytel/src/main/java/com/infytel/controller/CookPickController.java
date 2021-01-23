package com.infytel.controller;

import com.infytel.dto.EntityList;
import com.infytel.dto.Product;
import com.infytel.errors.ErrorMessage;
import com.infytel.exceptions.NoSuchProductException;
import com.infytel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class CookPickController {

    private final ProductService productService;

    @Autowired
    public CookPickController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/greets", produces = "application/json")
    public String greet() {
        LocalDate localDate = LocalDate.now();
        return "Welcome to " + localDate.getDayOfWeek() + " sale!!";
    }

    @GetMapping
    public List<Product> fetchProduct() {
        return productService.fetchProduct();
    }

    @GetMapping(value = "/{productName}")
    public List<Product> getProducts(@PathVariable("productName") String productName) {
        return productService.getProducts(productName);
    }


    @GetMapping("/getProduct")
    public List<Product> getProducts1(@RequestParam("productName") String productName,
                                      @RequestParam("productVendor") String productVendor) {
        return productService.getProducts(productName, productVendor);
    }

    @GetMapping(params = "version=2")
    public List<Product> getProducts1v2(@RequestParam("productName") String productName,
                                        @RequestParam("productVendor") String productVendor) {
        return productService.getProducts(productName, productVendor);
    }

    @PostMapping(value = "/addProduct", consumes = "application/json")
    public ResponseEntity addProduct(@Valid @RequestBody Product product, Errors errors) {
        String response = "";
        if (errors.hasErrors()) {
            response = errors
                    .getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors
                            .joining(","));
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
            errorMessage.setMessage(response);
            return ResponseEntity.ok(errorMessage);

        } else {
            response = productService.addProduct(product);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping(value = "/{query}/product", produces = {"application/xml"})
    public EntityList<Product> getProducts3(@MatrixVariable(pathVar = "query") Map<String, List<String>> map) {
        Set<String> keys = map.keySet();
        List<String> vendorList = new ArrayList<>();
        for (String key : keys) {
            vendorList.addAll(map.get(key));
        }
        return new EntityList<>(productService.getProducts3(vendorList));
    }

    @DeleteMapping(value = "/{productId}")
    public String deleteProduct(@PathVariable("productId") int productId) throws NoSuchProductException {
        return productService.deleteProduct(productId);
    }

    /*@CrossOrigin(allowedHeaders = "*", origins = "*")
    @GetMapping
    public List<String> getOffers() {
        List<String> offers=new ArrayList<>();
        offers.add("asdfasd");
        offers.add("asdfasd");
        return offers;
    }*/
}
