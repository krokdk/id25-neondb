package com.id25.neondb.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    void shouldSaveAndLoadProduct() {
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(BigDecimal.valueOf(99.99));
        product.setStatus("V2");

        Product saved = repository.save(product);

        Product found = repository.findById(saved.getId()).orElseThrow();

        assertThat(found.getName()).isEqualTo("Test Product");
        assertThat(found.getStatus()).isEqualTo("V2");
        assertThat(found.getPrice()).isEqualByComparingTo("99.99");
    }
}
