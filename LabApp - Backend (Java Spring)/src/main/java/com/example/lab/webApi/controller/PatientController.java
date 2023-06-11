package com.example.lab.webApi.controller;

import com.example.lab.business.abstracts.PatientService;
import com.example.lab.core.utilities.exceptions.BusinessException;
import com.example.lab.core.utilities.results.DataResult;
import com.example.lab.core.utilities.results.Result;
import com.example.lab.dtos.requests.patientRequests.CreatePatientRequest;
import com.example.lab.dtos.requests.patientRequests.UpdatePatientRequest;
import com.example.lab.dtos.responses.GetByIdPatientResponse;
import com.example.lab.dtos.responses.PatientListResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/patient")
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Result add(@RequestBody  CreatePatientRequest createPatientRequest ) throws BusinessException {
        return this.patientService.add(createPatientRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdatePatientRequest updatePatientRequest) throws BusinessException {
       return this.patientService.update(updatePatientRequest);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) throws BusinessException {
       return this.patientService.delete(id);
    }
    @GetMapping("/getAll")
    public DataResult<List<PatientListResponse>> getAll() throws BusinessException {
        return patientService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<GetByIdPatientResponse> getById(@PathVariable Long id) throws BusinessException {
        return patientService.getById(id);
    }

}
