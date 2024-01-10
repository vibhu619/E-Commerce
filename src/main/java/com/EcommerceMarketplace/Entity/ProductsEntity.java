package com.EcommerceMarketplace.Entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductsEntity {
    public List<ProductEntity> productEntityList;
}
