package com.example.lab.dtos.requests.laborantRequests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLaborantRequest {
    @NotNull
    public Long hospitalId;
    @NotNull
    public String name;
    @NotNull
    public String lastName;
}
