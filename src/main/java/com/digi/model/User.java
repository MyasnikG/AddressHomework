package com.digi.model;


import com.digi.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String password;
    private String verifyCode;
    private Status status;

}
