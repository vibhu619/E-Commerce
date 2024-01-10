package com.EcommerceMarketplace.Repository;

import com.EcommerceMarketplace.Entity.ProductEntity;
import com.EcommerceMarketplace.Entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    Optional<ProductEntity> findByName(String name);

}
