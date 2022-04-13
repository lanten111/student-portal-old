package co.za.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Getter
@Setter
public class Address {

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "BUILDING_NUMBER")
    private String buildingNumber;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "COUNTRY")
    private String country;

}


