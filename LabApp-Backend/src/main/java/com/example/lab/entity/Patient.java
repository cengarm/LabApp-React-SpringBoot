package com.example.lab.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @Column(name = "identification_number", unique = true, length = 11)
    private String identificationNumber;

    @Column(name = "first_name" )
    private String firstName;

    @Column(name = "last_name" )
    private String lastName;

    @Column(name = "complaint_name")
    private String complaintName;

    @ManyToOne()
    @JoinColumn(name = "patient_id")
    private Laborant laborant;

    @OneToMany(mappedBy = "patient")
    private List <Report> reports;

}
