package com.yjproject.overnight.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@DiscriminatorValue("T")
public class Topping extends Item{
    private String fruits;
    private String nuts;
    private String syrups;
}
