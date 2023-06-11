package com.example.lab.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "laborants")
public class Laborant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



    @Column(name = "hospital_id")
    private Long hospitalId;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "laborant")
    @JsonIgnore
    private List <Report> reports;






}
