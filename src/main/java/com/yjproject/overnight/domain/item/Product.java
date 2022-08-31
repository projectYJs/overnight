package com.yjproject.overnight.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {

    @Id @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "oatmeal_item_id")
    private Oatmeal oatmeal;

    @ManyToOne
    @JoinColumn(name = "yogurt_item_id")
    private Yogurt yogurt;

    @ManyToOne
    @JoinColumn(name = "topping_item_id")
    private Topping topping;

    private Integer price;
}
