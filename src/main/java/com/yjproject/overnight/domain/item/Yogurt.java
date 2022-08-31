package com.yjproject.overnight.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter @Setter
@DiscriminatorValue("Y")
public class Yogurt extends Item{

    @Enumerated(EnumType.STRING)
    private YogurtType yogurtType;
}
