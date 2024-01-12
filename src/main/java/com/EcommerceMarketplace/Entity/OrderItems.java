package com.EcommerceMarketplace.Entity;

import lombok.Builder;
import lombok.Data;
import org.apache.kafka.common.protocol.types.Field;

@Data
@Builder
public class OrderItems {

    public Integer orderItemId;

    public Integer quantity;

    public Integer productId;

    public Integer orderId;
}
