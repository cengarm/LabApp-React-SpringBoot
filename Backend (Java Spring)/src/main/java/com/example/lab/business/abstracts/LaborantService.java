package com.example.lab.business.abstracts;

import com.example.lab.core.utilities.exceptions.BusinessException;
import com.example.lab.core.utilities.results.DataResult;
import com.example.lab.core.utilities.results.Result;
import com.example.lab.dtos.requests.laborantRequests.CreateLaborantRequest;
import com.example.lab.dtos.requests.laborantRequests.UpdateLaborantRequest;
import com.example.lab.dtos.responses.GetByIdLaborantResponse;
import com.example.lab.dtos.responses.LaborantListResponse;
import com.example.lab.dtos.responses.ReportListResponse;

import java.util.List;

public interface LaborantService {
    Result add (CreateLaborantRequest createLaborantRequest) throws BusinessException;
    Result update (UpdateLaborantRequest updateLaborantRequest) throws BusinessException;
    Result delete (Long id) throws BusinessException;
    DataResult<List<LaborantListResponse>> getAll() ;
    DataResult<GetByIdLaborantResponse> getById(Long laborantId);
}
