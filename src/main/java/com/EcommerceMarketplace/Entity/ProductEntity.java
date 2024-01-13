package com.EcommerceMarketplace.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name="name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "price")
    public Integer price;

    @Column(name = "quantity")
    public Integer quantity;

    @Column(name = "seller_id")
    public Integer sellerId;

    @Column(name="average_rating")
    public Double rating;

}
