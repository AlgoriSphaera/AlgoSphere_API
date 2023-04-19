package com.sj.algosphere.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "`User`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSeqGenerator")
    @SequenceGenerator(name = "UserSeqGenerator", sequenceName = "`UserSeq`", allocationSize = 1)
    @NotNull
    @Column(name = "`id`")
    private Long id;

    @NotNull
    @Column(name = "`email`")
    private String email;

    @JsonIgnore
    @NotNull
    @Column(name = "`password`")
    private String password;
    
}
