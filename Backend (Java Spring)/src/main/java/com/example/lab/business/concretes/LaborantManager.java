package com.example.lab.business.concretes;

import com.example.lab.business.abstracts.LaborantService;
import com.example.lab.core.utilities.exceptions.BusinessException;
import com.example.lab.core.utilities.mapping.ModelMapperService;
import com.example.lab.core.utilities.messages.BusinessMessages;
import com.example.lab.core.utilities.results.*;
import com.example.lab.dataAccess.LaborantRepository;
import com.example.lab.dtos.requests.laborantRequests.CreateLaborantRequest;
import com.example.lab.dtos.requests.laborantRequests.UpdateLaborantRequest;
import com.example.lab.dtos.responses.GetByIdLaborantResponse;
import com.example.lab.dtos.responses.LaborantListResponse;
import com.example.lab.entity.concretes.Laborant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
//@CrossOrigin(origins = "http://localhost:3000") //for react
public class LaborantManager implements LaborantService {

    private ModelMapperService modelMapperService;
    private LaborantRepository laborantRepository;


    @Override
    public Result add(CreateLaborantRequest createLaborantRequest) throws BusinessException {
        try {
            Laborant laborant = this.modelMapperService.forRequest().map(createLaborantRequest, Laborant.class);
            this.laborantRepository.save(laborant);
            log.info(BusinessMessages.LogMessages.ADD_OPERATINON_WORK + "LaborantManager -> Add Operation");
            return new SuccessResult(BusinessMessages.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
        } catch (Exception exception) {
            log.warn(BusinessMessages.LogMessages.ADD_OPERATINON_NOT_WORK);
            return new ErrorResult(exception.getMessage());
        }
    }


    @Override
    public Result update(UpdateLaborantRequest updateLaborantRequest) throws BusinessException {
        try {
            Laborant laborant = this.modelMapperService.forRequest().map(updateLaborantRequest, Laborant.class);
            this.laborantRepository.save(laborant);
            log.info(BusinessMessages.LogMessages.UPDATE_OPERATINON_WORK + "LaborantManager -> Update Operation");
            return new SuccessResult(BusinessMessages.GlobalMessages.DATA_UPDATED_SUCCESSFULLY);
        }catch (Exception exception){
            log.warn(BusinessMessages.LogMessages.UPDATE_OPERATINON_NOT_WORK);
            return new ErrorResult(exception.getMessage());
        }
    }

    @Override
        public Result delete (Long id) throws BusinessException {
        try {
            this.laborantRepository.deleteById(id);
            log.info(BusinessMessages.LogMessages.DELETE_FROM_DATABASE + "LaborantManager -> Delete Operation");
            return new SuccessResult(BusinessMessages.GlobalMessages.DATA_DELETED_SUCCESSFULLY);
        }catch(Exception exception){
                log.warn(BusinessMessages.LogMessages.DELETE_OPERATINON_NOT_WORK);
                return new ErrorResult(exception.getMessage());
            }
        }





    @Override
    public DataResult<List<LaborantListResponse>> getAll()  {

        List<Laborant> laborants = this.laborantRepository.findAll();
        List<LaborantListResponse> responses = laborants.stream().map(laborant -> this.modelMapperService.forResponse().
                map(laborant, LaborantListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(responses, BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);

    }

    @Override
    public DataResult<GetByIdLaborantResponse> getById(Long laborantId)  {
            Laborant laborant = this.laborantRepository.findById(laborantId).orElseThrow();
           GetByIdLaborantResponse response = this.modelMapperService.forResponse().map(laborant, GetByIdLaborantResponse.class);
        return new SuccessDataResult<>(response, BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }



}
