package com.example.demo.model;

import com.example.demo.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "player_answers")
public class PlayerAnswers extends Auditable {

    @Getter @Setter @NotBlank @Column( length= Constants.MAX_ANSWER_LEN )
    private String answer;

    @Getter @Setter
    private Round round;

    @Getter @Setter @NotNull
    private Player player;
}
