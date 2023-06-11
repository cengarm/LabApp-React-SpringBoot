package com.example.lab.dtos.requests.reportRequests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReportRequest {


    private Long fileNumber;

    private String diseaseName;
    private String diseaseDetails;
    public String photoUrl;
    private Long lobarantId;
    private Long patientId;
    @JsonIgnore
    @CreationTimestamp
    private LocalDateTime reportDate;


}
