package com.infytel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Product {
    private int id;
    @NotBlank
    @Size(min = 5, max = 10, message = "name should be min 5 and max 10 characters")
    private String name;
    private String vendor;
    private int price;
    private char inStock;
}
