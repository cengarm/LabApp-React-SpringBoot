package com.example.lab.dtos.requests.laborantRequests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLaborantRequest {
    @NotNull

    @Min(7)
    @Max(7)
    public Long hospitalId;
    @NotNull
    public String name;
    @NotNull
    public String lastName;
}
