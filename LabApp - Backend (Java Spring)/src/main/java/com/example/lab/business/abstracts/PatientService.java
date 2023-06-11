package com.example.lab.business.abstracts;

import com.example.lab.core.utilities.exceptions.BusinessException;
import com.example.lab.core.utilities.results.DataResult;
import com.example.lab.core.utilities.results.Result;
import com.example.lab.dtos.requests.patientRequests.CreatePatientRequest;
import com.example.lab.dtos.requests.patientRequests.UpdatePatientRequest;
import com.example.lab.dtos.responses.GetByIdPatientResponse;
import com.example.lab.dtos.responses.PatientListResponse;

import java.util.List;

    public interface PatientService {

        Result add (CreatePatientRequest createPatientRequest) throws BusinessException;
        Result update (UpdatePatientRequest updatePatientRequest) throws BusinessException;
        Result delete (Long patientId) throws BusinessException;
        DataResult<List<PatientListResponse>> getAll() throws BusinessException;
        DataResult<GetByIdPatientResponse> getById(Long patientId) throws BusinessException;
//
    }

