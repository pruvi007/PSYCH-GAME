package com.example.demo.model;

import com.example.demo.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table( name="questions" )
public class Question extends Auditable {

    @Getter @Setter @NotBlank @Column( length = Constants.MAX_QUESTION_LEN )
    private String questionText;

    @Getter @Setter @NotBlank @Column( length = Constants.MAX_ANSWER_LEN )
    private String correctAnswer;

    @Getter @Setter @NotNull
    private GameMode gameMode;

    @Getter @Setter @OneToMany( mappedBy = "question" )
    private List<EllenAnswers> ellenAnswers;
}
