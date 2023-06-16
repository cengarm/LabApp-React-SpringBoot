package com.example.lab.business.concretes;

import com.example.lab.business.abstracts.PatientService;
import com.example.lab.core.utilities.exceptions.BusinessException;
import com.example.lab.core.utilities.mapping.ModelMapperService;
import com.example.lab.core.utilities.messages.BusinessMessages;
import com.example.lab.core.utilities.results.*;
import com.example.lab.dataAccess.PatientRepository;
import com.example.lab.dtos.requests.patientRequests.CreatePatientRequest;
import com.example.lab.dtos.requests.patientRequests.UpdatePatientRequest;
import com.example.lab.dtos.responses.GetByIdPatientResponse;
import com.example.lab.dtos.responses.PatientListResponse;
import com.example.lab.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PatientManager implements PatientService {
    private final ModelMapperService modelMapperService;
    private final PatientRepository patientRepository;


    // GlobalExceptionHandler. ->
    // Servisindeki metodlar, diğer paketlerden de çağırılabilir olması gerekir.
    // DTO çevrimlerini, front'a sunarken sadece controller üzerinde çevir.


    @Override
    public Result add(
            CreatePatientRequest createPatientRequest
    )throws BusinessException {
        try {
            Patient patient = this.modelMapperService.forRequest().map(createPatientRequest, Patient.class);
            patient = this.patientRepository.save(patient);
            return new SuccessResult(BusinessMessages.GlobalMessages.DATA_CREATED_SUCCESSFULY);

        } catch (Exception exception) {
            log.warn(BusinessMessages.LogMessages.ADD_OPERATINON_NOT_WORK);
            return new ErrorResult(exception.getMessage());
        }
    }

    @Override
    public Result update(UpdatePatientRequest updatePatientRequest) throws BusinessException {
        try {
            Patient patient = this.modelMapperService.forRequest().map(updatePatientRequest,Patient.class);
            this.patientRepository.save(patient);
            return new SuccessResult(BusinessMessages.GlobalMessages.DATA_UPDATED_SUCCESSFULLY);
        }catch (Exception exception){
            log.warn(BusinessMessages.LogMessages.UPDATE_OPERATINON_NOT_WORK);
            return new ErrorResult(exception.getMessage());
        }
    }

    @Override
    public Result delete(Long patientId) throws BusinessException {
        try {
            this.patientRepository.deleteById(patientId);
            log.info(BusinessMessages.LogMessages.DELETE_FROM_DATABASE + "LaborantManager -> Delete Operation");
            return new SuccessResult(BusinessMessages.GlobalMessages.DATA_DELETED_SUCCESSFULLY);
        }catch(Exception exception){
            log.warn(BusinessMessages.LogMessages.DELETE_OPERATINON_NOT_WORK);
            return new ErrorResult(exception.getMessage());
        }
    }


    @Override
    public DataResult<List<PatientListResponse>> getAll() throws BusinessException{

        List<Patient> patients = this.patientRepository.findAll();
        List<PatientListResponse> responses = patients.stream().map(patient -> this.modelMapperService.forResponse().
                map(patient ,PatientListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(responses, BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);

    }

    @Override
    public DataResult<GetByIdPatientResponse> getById(Long patientId) throws BusinessException {
        Patient patient = this.patientRepository.getById(patientId);
        GetByIdPatientResponse response =this.modelMapperService.forResponse().map(patient, GetByIdPatientResponse.class);
        return new SuccessDataResult<>(response, BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
}
}

