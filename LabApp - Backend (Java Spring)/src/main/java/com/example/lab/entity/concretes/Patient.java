package com.example.lab.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id; //Wrapper -> Integer

    @Length(min = 11 ,max = 11,message = "{validation.name.size}")
    @Column(name = "identification_number", unique = true)
    private Long identificationNumber;

    @Column(name = "name" )
    private String firstName;

    @Column(name = "last_name" )
    private String lastName;

//    @Column(name = "email")
//    private String email;
//
//    @Column(name = "password")
//    private String password;

    @Column(name = "complaint_name")
    private String complaintName;

    @ManyToOne(fetch = FetchType.EAGER) //
    @JoinColumn(name = "patient_id")
    private Laborant laborant;

    @OneToMany(mappedBy = "patient")
    private List <Report> reports;




}
