package com.example.lab.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdPatientResponse {
    private Long identificationNumber;
    private String firstName;
    private String lastName;
    private String complaintName;
}
