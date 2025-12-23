package com.id25.neondb.api;

import com.id25.neondb.product.CreateProductRequest;
import com.id25.neondb.product.Product;
import com.id25.neondb.product.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Long> createProduct(
            @RequestBody CreateProductRequest request
    ) {
        Product product = new Product();
        product.setName(request.name);
        product.setPrice(request.price);

        Product saved = repository.save(product);

        return ResponseEntity
                .created(URI.create("/products/" + saved.getId()))
                .body(saved.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
