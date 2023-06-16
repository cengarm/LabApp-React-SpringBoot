package com.example.lab.business.concretes;


import com.example.lab.business.abstracts.ReportService;
import com.example.lab.core.utilities.exceptions.BusinessException;
import com.example.lab.core.utilities.mapping.ModelMapperService;
import com.example.lab.core.utilities.messages.BusinessMessages;
import com.example.lab.core.utilities.results.*;
import com.example.lab.dataAccess.LaborantRepository;
import com.example.lab.dataAccess.ReportRepository;
import com.example.lab.dtos.requests.reportRequests.CreateReportRequest;
import com.example.lab.dtos.requests.reportRequests.UpdateReportRequest;
import com.example.lab.dtos.responses.GetByIdReportResponse;
import com.example.lab.dtos.responses.ReportListResponse;
import com.example.lab.entity.Report;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ReportManager implements ReportService {

    private final ModelMapperService modelMapperService;
    private final ReportRepository reportRepository;
    private final LaborantRepository laborantRepository;

    @Override
    public Result add(CreateReportRequest createReportRequest)throws BusinessException {
        try {
            Report report = this.modelMapperService.forRequest().map(createReportRequest,Report.class);

//            Report report = ReportMapper.conversionDtoToModel(createReportRequest);


//            Laborant laborant = new Laborant();
//            laborant = laborantRepository.findById(createReportRequest.getLobrant())
//                    .orElseThrow(()->new Exception("Böyle bir laborant yok."));
//                     report.setLaborant(laborant);

            report = this.reportRepository.save(report);
            log.info(BusinessMessages.LogMessages.ADD_OPERATINON_WORK + "ReportManager -> Add Operation");
            return new SuccessResult(BusinessMessages.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
        } catch (Exception exception) {
            log.warn(BusinessMessages.LogMessages.ADD_OPERATINON_NOT_WORK);
            return new ErrorResult(exception.getMessage());
        }
        }



    @Override
    public Result update(UpdateReportRequest updateReportRequest) throws BusinessException{
        try {
        Report report = this.modelMapperService.forRequest().map(updateReportRequest, Report.class);
        this.reportRepository.save(report);
        log.info(BusinessMessages.LogMessages.UPDATE_OPERATINON_WORK + "LaborantManager -> Update Operation");
        return new SuccessResult(BusinessMessages.GlobalMessages.DATA_UPDATED_SUCCESSFULLY);
        }catch (Exception exception){
            log.warn(BusinessMessages.LogMessages.UPDATE_OPERATINON_NOT_WORK);
            return new ErrorResult(exception.getMessage());
        }
    }

    @Override
    public Result delete(Long id) {
        try {
        this.reportRepository.deleteById(id);
        log.info(BusinessMessages.LogMessages.DELETE_FROM_DATABASE + " Report Manager -> Delete Operation");
        return new SuccessResult(BusinessMessages.GlobalMessages.DATA_DELETED_SUCCESSFULLY);
        }catch(Exception exception){
            log.warn(BusinessMessages.LogMessages.DELETE_OPERATINON_NOT_WORK);
            return new ErrorResult(exception.getMessage());
        }
    }

    @Override
    public DataResult<List<ReportListResponse>> getAll() {
        List<Report> reports = this.reportRepository.findAll();
        List<ReportListResponse> responses = reports.stream().map(report -> this.modelMapperService.forResponse().
                map(report, ReportListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(responses, BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);

    }

    @Override
    public DataResult<GetByIdReportResponse> getById(Long reportId) {
        Report report = this.reportRepository.getById(reportId);
        GetByIdReportResponse response = this.modelMapperService.forResponse().map(report, GetByIdReportResponse.class);
        return new SuccessDataResult<>(response, BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);

    }
}



