package com.EcommerceMarketplace.Controller;

import com.EcommerceMarketplace.Entity.ProductEntity;
import com.EcommerceMarketplace.Entity.ProductsEntity;
import com.EcommerceMarketplace.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/getProducts")
    @ResponseBody
    public ResponseEntity<ProductsEntity> getAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("/getProductById")
    public ResponseEntity<ProductEntity> getProductById(@RequestParam Integer id){
        return productService.getProductById(id);
    }
    @PostMapping("/addNewProduct")
    public ResponseEntity<String> addNewProduct(@RequestBody ProductEntity product){
        return productService.addNewProduct(product);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<String> updateProduct(@RequestParam String name , Integer quantity){
        return productService.update(name,quantity);
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<String> deleteProduct(@RequestParam Integer id){
        return productService.deleteProduct(id);
    }
}