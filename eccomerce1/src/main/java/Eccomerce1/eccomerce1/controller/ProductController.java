package Eccomerce1.eccomerce1.controller;

import Eccomerce1.eccomerce1.dto.CreateProductRequest;
import Eccomerce1.eccomerce1.entity.Product;
import Eccomerce1.eccomerce1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/save")
    public ResponseEntity<Product> updateProduct(@RequestBody CreateProductRequest dto) {
        Product updatedProduct = productService.saveProduct(dto);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}