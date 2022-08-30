package com.yjproject.overnight.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("O")
@Getter @Setter
public class Oatmeal extends Item{
    private String rolledOat;
    private String instantOat;

}
