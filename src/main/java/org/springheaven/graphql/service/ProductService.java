package org.springheaven.graphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springheaven.graphql.entity.Product;
import org.springheaven.graphql.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }


    public List<Product> getProductsByCategory(String category) {

        return productRepository.findByCategory(category);
    }


    //sales team :update the stock of a product in (IS)
    public Product updateStock(int id, int stock) {
        Product existingProduct = productRepository.
                findById(id).orElseThrow(
                () -> new RuntimeException("Product not found")
        );
        existingProduct.setStock(stock);
        return productRepository.save(existingProduct);
    }

    //sales team :update the stock of a product in (IS)
    public Product receiveNewShipment(int id, int quantity) {
        Product existingProduct = productRepository.
                findById(id).orElseThrow(
                        () -> new RuntimeException("Product not found")
                );
        existingProduct.setStock(existingProduct.getStock()+quantity);
        return productRepository.save(existingProduct);
    }

}
