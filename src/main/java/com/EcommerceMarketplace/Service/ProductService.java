package com.EcommerceMarketplace.Service;

import com.EcommerceMarketplace.Repository.ProductRepository;
import com.EcommerceMarketplace.Entity.ProductEntity;
import com.EcommerceMarketplace.Entity.ProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public ResponseEntity<ProductsEntity> getProducts() {

        List<ProductEntity> productEntities=productRepository.findAll();
        ProductsEntity productsEntitiy=ProductsEntity.builder()
                                                     .productEntityList(productEntities)
                                                     .build();
        return new ResponseEntity<>(productsEntitiy, HttpStatus.OK);
    }

    public ResponseEntity<ProductEntity> getProductById(Integer id){
        ProductEntity product=productRepository
                .findById(id)
                .orElseThrow();
        return new ResponseEntity<>(product,HttpStatus.OK);

    }


    public ResponseEntity<String> addNewProduct(ProductEntity product) {
        productRepository.save(product);
        return new ResponseEntity<>("Successfully added a new product",HttpStatus.OK);
    }

    public ResponseEntity<String> update(String name, Integer quantity) {
        ProductEntity product=productRepository.findByName(name).orElseThrow();
        product.setQuantity(product.getQuantity()+quantity);
        productRepository.save(product);
        return new ResponseEntity<>("Quantity update for " + name +" successfully",HttpStatus.OK );
    }

    public ResponseEntity<String> deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return new ResponseEntity<>("Delete product successfully",HttpStatus.OK);
    }
}
