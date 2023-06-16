package com.example.lab.webApi.controller;

import com.example.lab.business.abstracts.LaborantService;
import com.example.lab.core.utilities.exceptions.BusinessException;
import com.example.lab.core.utilities.results.DataResult;
import com.example.lab.core.utilities.results.ErrorResult;
import com.example.lab.core.utilities.results.Result;
import com.example.lab.dtos.requests.laborantRequests.CreateLaborantRequest;

import com.example.lab.dtos.requests.laborantRequests.UpdateLaborantRequest;
import com.example.lab.dtos.responses.GetByIdLaborantResponse;
import com.example.lab.dtos.responses.LaborantListResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class LaborantController {
    private final LaborantService laborantService;

    @PostMapping("/laborants")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Result add(@RequestBody @Valid CreateLaborantRequest createLaborantRequest) {
        try{
        return this.laborantService.add(createLaborantRequest);
        }catch (Exception exception){
            return new ErrorResult(exception.getMessage());
        }
    }

    @PutMapping("/laborants/{id}")
    public Result update(@RequestBody @Valid UpdateLaborantRequest updateLaborantRequest, @PathVariable("id") Long id
    ) {
        try {
            return this.laborantService.update(id, updateLaborantRequest);
        } catch (Exception exception) {
            return new ErrorResult(exception.getMessage());
        }
    }

    @DeleteMapping("/laborants/{id}")
    public Result delete(@PathVariable Long id) throws BusinessException {
        return this.laborantService.delete(id);
    }

    @GetMapping("/laborants")
    public DataResult<List<LaborantListResponse>> getAll() {
        return laborantService.getAll();
    }

    @GetMapping("/laborants/{id}")
    public DataResult<GetByIdLaborantResponse> getById(Long id) {
        return laborantService.getById(id);
    }
}
