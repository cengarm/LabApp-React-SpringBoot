package com.example.lab.webApi.controller;

import com.example.lab.business.abstracts.PatientService;
import com.example.lab.core.utilities.exceptions.BusinessException;
import com.example.lab.core.utilities.results.DataResult;
import com.example.lab.core.utilities.results.Result;
import com.example.lab.dtos.requests.patientRequests.CreatePatientRequest;
import com.example.lab.dtos.requests.patientRequests.UpdatePatientRequest;
import com.example.lab.dtos.responses.GetByIdPatientResponse;
import com.example.lab.dtos.responses.PatientListResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/patients")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Result add(@RequestBody @Valid CreatePatientRequest createPatientRequest ) throws BusinessException {
        return this.patientService.add(createPatientRequest);
    }

    @PutMapping("/patients/{id}")
    public Result update(@RequestBody @Valid UpdatePatientRequest updatePatientRequest) throws BusinessException {
       return this.patientService.update(updatePatientRequest);
    }
    @DeleteMapping("/patients/{id}")
    public Result delete(@PathVariable Long id) throws BusinessException {
       return this.patientService.delete(id);
    }
    @GetMapping("/patients")
    public DataResult<List<PatientListResponse>> getAll() throws BusinessException {
        return patientService.getAll();
    }

    @GetMapping("/patients/{id}")
    public DataResult<GetByIdPatientResponse> getById(@PathVariable Long id) throws BusinessException {
        return patientService.getById(id);
    }

}
