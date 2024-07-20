package org.springheaven.graphql.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springheaven.graphql.entity.Product;
import org.springheaven.graphql.service.ProductService;

import java.util.List;

@Controller
public class ProductController {


    @Autowired
    private ProductService productService;


    @QueryMapping
    public List<Product> getProducts() {
        
        return productService.getAllProducts(); 
    }


    @QueryMapping
    public List<Product> getProductsByCategory(@Argument String category) {
        return productService.getProductsByCategory(category);

    }


    @MutationMapping
    public Product updateStock(@Argument int id,@Argument int stock){
        return productService.updateStock(id,stock);
    }

    @MutationMapping
    public Product receiveNewShipment(@Argument int id,@Argument int quantity){
        return productService.updateStock(id,quantity);
    }

}
