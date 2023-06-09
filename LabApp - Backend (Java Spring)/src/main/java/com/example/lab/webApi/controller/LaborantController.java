package com.example.lab.webApi.controller;

import com.example.lab.business.abstracts.LaborantService;
import com.example.lab.core.utilities.exceptions.BusinessException;
import com.example.lab.core.utilities.results.DataResult;
import com.example.lab.core.utilities.results.Result;
import com.example.lab.dtos.requests.laborantRequests.CreateLaborantRequest;
import com.example.lab.dtos.requests.laborantRequests.UpdateLaborantRequest;
import com.example.lab.dtos.responses.GetByIdLaborantResponse;
import com.example.lab.dtos.responses.LaborantListResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laborant")
@AllArgsConstructor
public class LaborantController {
    private final LaborantService laborantService;

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Result add(@RequestBody CreateLaborantRequest createLaborantRequest) throws BusinessException {
       return this.laborantService.add(createLaborantRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateLaborantRequest updateLaborantRequest) throws BusinessException {
       return this.laborantService.update(updateLaborantRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) throws BusinessException {
     return this.laborantService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<LaborantListResponse>> getAll()  {
        return laborantService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<GetByIdLaborantResponse> getById(Long id)  {
        return laborantService.getById(id);
    }

}
