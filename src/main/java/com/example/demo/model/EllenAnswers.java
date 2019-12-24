package com.example.demo.model;

import com.example.demo.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(  name="ellen_answers")
public class EllenAnswers extends Auditable{

    @Getter @Setter @ManyToOne
    private Question question;

    @Getter @Setter @NotBlank @Column( length= Constants.MAX_ANSWER_LEN )
    private String answer;

    @Getter @Setter
    private long votes = 0;
}
