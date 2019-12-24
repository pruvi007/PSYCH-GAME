package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name="stats" )
public class Stats extends Auditable {

    @Getter @Setter
    private long correctAnswers = 0;

    @Getter @Setter
    private long gotPsyched = 0;

    @Getter @Setter
    private long psychedOthers = 0;
}
