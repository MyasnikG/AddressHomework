package com.digi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private int addressID;
    private String country;
    private String city;
    private String street;
    private String house;

    private int userID;

}
