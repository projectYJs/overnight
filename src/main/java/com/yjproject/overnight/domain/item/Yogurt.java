package com.yjproject.overnight.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@DiscriminatorValue("Y")
public class Yogurt extends Item{

    private String plainYogurt;
    private String greekYogurt;
}
