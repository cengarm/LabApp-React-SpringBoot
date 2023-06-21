package com.example.lab.dtos.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdReportResponse {
    private Long   id;
    private String diseaseName;
    private String diseaseDetails;
    private String name;
    private String lastName;
    @JsonIgnore
    @CreationTimestamp
    private Long reportDate;

}
