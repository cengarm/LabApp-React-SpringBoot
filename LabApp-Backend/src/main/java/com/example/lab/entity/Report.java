package com.example.lab.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reports")
public class Report  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "file_number")
    private String fileNumber;

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

    @ManyToOne
    @JoinColumn(name = "l_fk_id")
    private Laborant laborant;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "p_fk_id")
    private Patient patient;

}
