package com.yjproject.overnight.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("O")
@Getter @Setter
public class Oatmeal extends Item{

    @Enumerated(EnumType.STRING)
    private OatmealType oatmealType;

}
