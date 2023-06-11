package com.example.lab.entity.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reports")
public class Report  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "file_number")
    private Long fileNumber;

    @Column(name = "disease_name")
    private String diseaseName;

    @Column(name = "disease_details")
    private String diseaseDetails;

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "report_date")
    private LocalDateTime reportDate;

    @Column(name = "photo_url")
    private String photoUrl;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "lab_id")
    private Laborant laborant;

    @ManyToOne (fetch = FetchType.EAGER) //Default lazy
    @JoinColumn(name = "p_fk_id")
    private Patient patient;

}
