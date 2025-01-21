package org.example.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product create(Product product) {
        productRepository
                .productList
                .add(product);
        return product;
    }

    public Product getByProductId(int id) {
        return productRepository
                .productList
                .stream()
                .filter(u -> Objects.equals(u.getId(), id))
                .findAny()
                .orElse(null);
    }

    public List<Product> getAllProducts() {
        return productRepository.productList;
    }

    public Product updateProductById(int id, String newName, double newPrice) {
        if(getByProductId(id) != null) {
            Product product = getByProductId(id);
            product.setName(newName);
            product.setPrice(newPrice);
            return product;
        } else {
            return null;
        }
    }

    public Product deleteProductById(int id) {
        if (getByProductId(id) != null) {
            Product product = getByProductId(id);
            productRepository.productList.remove(product);
            return product;
        } else {
            return null;
        }
    }
}
