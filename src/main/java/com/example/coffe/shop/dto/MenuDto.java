package com.example.coffe.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDto {
    private String prodCode;
    private String name;
    private String engName;
    private String description;
    private String imageUrl;
    private String volume;
    private String calorie;
    private String saturatedFat;
    private String protein;
    private String sodium;
    private String sugar;
    private String caffeine;
    private String allergy;
}
