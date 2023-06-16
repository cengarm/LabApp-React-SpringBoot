package com.example.lab.dtos.requests.laborantRequests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateLaborantRequest {

    @Size(min = 7, max = 7, message = "Hospital ID must be 7 characters")
    private  String hospitalId;

    private String name;

    private String lastName;
}
