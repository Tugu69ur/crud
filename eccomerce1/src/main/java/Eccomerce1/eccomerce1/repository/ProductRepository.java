package Eccomerce1.eccomerce1.repository;


import Eccomerce1.eccomerce1.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
    Optional<Product> findByProductName(String name);
}
