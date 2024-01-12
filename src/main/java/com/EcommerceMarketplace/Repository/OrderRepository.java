package com.EcommerceMarketplace.Repository;

import com.EcommerceMarketplace.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
    Optional<OrderEntity> findByUserId(Integer id);
}
