package com.example.lab.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaborantListResponse {
    private Long labId;
    private Long hospitalid;
    private String name;
    private String lastName;
}
