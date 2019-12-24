package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Entity
@Table( name="rounds" )
public class Round extends Auditable{
    @Getter @Setter @ManyToOne @NotNull
    private Game game;

    @ManyToOne @Getter @Setter
    private Question question;

    @Getter @Setter @NotNull
    private int roundNumber;

    @ManyToMany @Getter @Setter
    private Map<Player,PlayerAnswers> playerAnswers;
}
