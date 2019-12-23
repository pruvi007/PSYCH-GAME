package com.example.demo.model;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="players")
public class Player extends Auditable {

    @Getter @Setter @NotBlank
    private String name;



}
