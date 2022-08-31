package com.yjproject.overnight.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class AddressInfo {

    private String city;
    private String street;
    private String zipcode;
    private String phoneNumber;

    protected AddressInfo(){
        ;
    }

    public AddressInfo(String city, String street, String zipcode, String phoneNumber) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
    }
}
