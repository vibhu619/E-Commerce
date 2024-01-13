package com.EcommerceMarketplace.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.events.Event;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer review_id;

    @Column(name = "rating")
    public Double rating;

    @Column(name = "comment")
    public String comment;

    @Column(name = "user_id")
    public Integer userId;

    @Column(name = "product_id")
    public Integer productId;

    @Column(name = "date_of_review")
    public Date reviewDate;
}
