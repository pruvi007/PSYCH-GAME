package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="players")
public class Player extends Auditable {


    @Getter @Setter @NotBlank
    private String name;

    @Getter @Setter @URL
    private String psychFaceUrl;

    @Getter @Setter @URL
    private String picUrl;

    // one player will have one stats
    @Getter @Setter @OneToOne
    private Stats stats;

    @Getter @Setter @ManyToMany( mappedBy = "players")
    private List<Game> games;

}
