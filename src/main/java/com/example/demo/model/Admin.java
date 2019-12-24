package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name="admins" )
public class Admin extends Employee {
}
