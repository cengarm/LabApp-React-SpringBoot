package com.example.lab.dtos.requests.laborantRequests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLaborantRequest {

    @Size(min = 7, max = 7, message = "Hospital ID must be 7 characters")
    @NotNull
    public String hospitalId;
    @NotNull
    public String name;
    @NotNull
    public String lastName;
}
