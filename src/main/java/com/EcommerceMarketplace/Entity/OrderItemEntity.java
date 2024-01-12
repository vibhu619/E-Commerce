package com.EcommerceMarketplace.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_item")
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  Integer id;

    @Column(name = "oit_quantity_ordered")
    public Integer quantity;

    @Column(name = "oit_subtotal")
    public Integer subtotal;

    @Column(name = "oit_product_id")
    public Integer productId;

    @Column(name = "oit_order_id")
    public Integer order_id;


}
