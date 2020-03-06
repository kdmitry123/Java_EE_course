package by.pvt.controller;

import by.pvt.dto.ProductDto;
import by.pvt.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductCatalogController {

    @Autowired
    ProductCatalogService productCatalogService;

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return productCatalogService.getProducts(100);
    }

    @GetMapping("/product") // localhost:8080/product?id=123
    public ProductDto getProduct(@RequestParam long id) {
        return productCatalogService.get(id);
    }

    @PostMapping("/product")
    public void createNewProduct(@RequestBody CreateProductCmd createProductCmd) {
        productCatalogService.create(createProductCmd);
    }

    @PutMapping("/product/{id}")
    public void updateProduct(@PathVariable long id,
                              @RequestBody UpdateProductCmd updateProductCmd) {
        productCatalogService.update(id, updateProductCmd);
    }

}
