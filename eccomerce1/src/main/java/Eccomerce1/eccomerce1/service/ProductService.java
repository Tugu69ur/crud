package Eccomerce1.eccomerce1.service;


import Eccomerce1.eccomerce1.dto.CreateProductRequest;
import Eccomerce1.eccomerce1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Eccomerce1.eccomerce1.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProduct(String type, String value) {
        return switch (type) {
            case "id" -> productRepository.findById(value).orElseThrow();
            case "name" -> productRepository.findByProductName(value).orElseThrow();
            default -> throw new IllegalArgumentException("type.not.valid");
        };
    }

    public Product saveProduct(CreateProductRequest dto) {
        Product product;
        if (dto.getId() != null && productRepository.findById(String.valueOf(dto.getId())).isPresent()) {
            product = productRepository.findById(String.valueOf(dto.getId())).get();
        } else {
            product = new Product();
        }

        product.setProductName(dto.getName());
        product.setDescription(dto.getDesc());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());
        product.setCreatedDate(LocalDateTime.now());
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        Product product = productRepository.findById(String.valueOf(id)).orElseThrow();
        productRepository.delete(product);
    }
}