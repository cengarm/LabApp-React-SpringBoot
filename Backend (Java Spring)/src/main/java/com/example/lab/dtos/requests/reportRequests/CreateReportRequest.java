package com.example.lab.dtos.requests.reportRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReportRequest {

    @NotNull
    public String photoUrl;
    @NotNull
    private Long fileNumber;
    @NotNull
    private String diseaseName;
    @NotNull
    private String diseaseDetails;
    @NotNull
    private Long lobarantId;
    @NotNull
    private Long patientId;
    @JsonIgnore
    @CreationTimestamp
    private LocalDateTime reportDate;



}
