package hello.item_service.repository;

import hello.item_service.domain.Product;

import java.util.ArrayList;

public interface ProductRepository {
    ArrayList<Product> findAll();
    Product findById(Long productId);
    Product save(Product product);
    Product update(Long productId, Product updateParam);

}
