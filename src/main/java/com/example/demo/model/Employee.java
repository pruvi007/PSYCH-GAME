package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class Employee extends Auditable{

    @Getter @Setter @NotBlank
    private String name;

    @Getter @Setter @Email @NotBlank
    private String email;

    @Getter @Setter
    private String address;

    @Getter @Setter
    private String phoneNumber;

}
