package com.EcommerceMarketplace.Repository;

import com.EcommerceMarketplace.Entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer> {
    Optional<List<ReviewEntity>> findByProductId(Integer productId);
}
