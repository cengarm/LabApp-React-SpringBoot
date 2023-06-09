package com.example.lab.business.abstracts;

import com.example.lab.core.utilities.exceptions.BusinessException;
import com.example.lab.core.utilities.results.DataResult;
import com.example.lab.core.utilities.results.Result;
import com.example.lab.dtos.requests.reportRequests.CreateReportRequest;
import com.example.lab.dtos.requests.reportRequests.UpdateReportRequest;
import com.example.lab.dtos.responses.GetByIdReportResponse;
import com.example.lab.dtos.responses.ReportListResponse;

import java.util.List;

public interface ReportService {
    Result add(CreateReportRequest createReportRequest) throws BusinessException;
    Result delete(Long reportId) throws BusinessException;
    Result update(UpdateReportRequest updateReportRequest) throws BusinessException;
    DataResult<List<ReportListResponse>> getAll()throws BusinessException;
    DataResult<GetByIdReportResponse> getById(Long reportId)throws BusinessException;
}
