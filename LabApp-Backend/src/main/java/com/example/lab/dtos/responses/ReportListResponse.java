package com.example.lab.dtos.responses;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportListResponse {

    private String firstName;
    private String patientLastName;
    private Long reportId;
    private Long fileNumber;
    private Long identificationNumber;
    private String diseaseName;
    private String diseaseDetails;
    private String photoUrl;
    private LocalDateTime reportDate;
    private String laborantHospitalId;
    private String laborantFirstName;
    private String laborantLastName;


}
