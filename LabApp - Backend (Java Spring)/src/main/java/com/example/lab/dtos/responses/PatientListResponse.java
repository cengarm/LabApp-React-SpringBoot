package com.example.lab.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientListResponse {
    private Long patientId;;
    private Long identificationNumber;
    private String firstName;
    private String lastName;
    private String complaintName;


}
