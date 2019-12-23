package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties( value= {"createdAt","updatedAt"}, allowGetters = true)
public abstract class Auditable implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
    private Long id;

    @Column(nullable = false,updatable = false) @CreatedDate @Temporal(TemporalType.TIMESTAMP) @Getter @Setter
    private Date createdAt = new Date();

    @Column(nullable = false) @Temporal(TemporalType.TIMESTAMP) @LastModifiedDate @Getter @Setter
    private Date updatedAt = new Date();

}
