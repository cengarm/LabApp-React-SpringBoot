package com.example.lab.webApi.controller;

import com.example.lab.business.abstracts.ReportService;
import com.example.lab.core.utilities.exceptions.BusinessException;
import com.example.lab.core.utilities.results.DataResult;
import com.example.lab.core.utilities.results.Result;
import com.example.lab.dtos.requests.reportRequests.CreateReportRequest;
import com.example.lab.dtos.requests.reportRequests.UpdateReportRequest;
import com.example.lab.dtos.responses.GetByIdReportResponse;
import com.example.lab.dtos.responses.ReportListResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class ReportController {
    private final ReportService reportService;


    @PostMapping("/reports")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Result add(@RequestBody CreateReportRequest createReportRequest) throws BusinessException {
        return this.reportService.add(createReportRequest);
    }
    @PutMapping("/reports")
    public Result update(@RequestBody UpdateReportRequest updateReportRequest) throws BusinessException {
         return this.reportService.update(updateReportRequest);
    }
    @DeleteMapping("/reports/{id}")
    public Result delete(@PathVariable Long id) throws BusinessException {
       return this.reportService.delete(id);
    }
    @GetMapping("/reports")
    public DataResult<List<ReportListResponse>> getAll() throws BusinessException {
        return this.reportService.getAll();
    }
    @GetMapping("/reports/{id}")
    public DataResult<GetByIdReportResponse> getById(Long id) throws BusinessException {
        return this.reportService.getById(id);
    }



}

