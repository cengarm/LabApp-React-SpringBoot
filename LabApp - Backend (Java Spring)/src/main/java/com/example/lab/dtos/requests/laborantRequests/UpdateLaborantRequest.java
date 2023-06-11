package com.example.lab.dtos.requests.laborantRequests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLaborantRequest {

    @NotNull
    private Long hospitalId;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
}
