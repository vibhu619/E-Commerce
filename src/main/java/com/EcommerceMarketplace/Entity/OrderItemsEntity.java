package com.EcommerceMarketplace.Entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderItemsEntity {
    public List<OrderItemEntity> orderItemList;
}
