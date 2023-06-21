package com.example.lab.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "laborants")
public class Laborant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hospital_id",unique = true)
    @Size(min = 7, max = 7, message = "Hospital ID must be 7 characters")
    private String hospitalId;

    @Size(max = 50)
    @Column(name = "name")
    private String name;

    @Size(max = 50)
    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "laborant")
    @JsonIgnore
    private List <Report> reports;

    @OneToMany(fetch = FetchType.EAGER) //
    @JoinColumn(name = "laborant_id")
    @JsonIgnore
    private List <Patient> patients;




}
