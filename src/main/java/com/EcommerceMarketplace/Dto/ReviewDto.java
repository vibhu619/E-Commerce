package com.EcommerceMarketplace.Dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReviewDto {

    public Double rating;
    public String comments;
    public String reviewDate;
}
