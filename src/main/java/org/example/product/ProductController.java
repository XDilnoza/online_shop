package org.example.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping("/get-all")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/get-id")
    public Product getProduct(@RequestParam("id") int id) {
        return productService.getByProductId(id);
    }

    @PutMapping("/update-product/{id}/{name}/{price}")
    public Product updateProduct(@PathVariable("id") int id,
                                 @PathVariable("name") String name,
                                 @PathVariable("price") double price) {
        return productService.updateProductById(id,name,price);
    }

    @DeleteMapping("/delete-product/{id}")
    public Product deleteProduct(@PathVariable("id") int id) {
        return productService.deleteProductById(id);
    }
}
