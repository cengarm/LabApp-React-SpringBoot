package com.example.lab.business.concretes;

import com.example.lab.business.abstracts.ReportService;
import com.example.lab.core.utilities.exceptions.BusinessException;
import com.example.lab.core.utilities.mapping.ModelMapperManager;
import com.example.lab.core.utilities.mapping.ModelMapperService;
import com.example.lab.dataAccess.ReportRepository;
import com.example.lab.dtos.requests.reportRequests.CreateReportRequest;
import com.example.lab.dtos.responses.GetByIdReportResponse;
import com.example.lab.dtos.responses.ReportListResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.testng.annotations.Test;

public class ReportManagerTest {
    ReportManager reportManager;
    ReportService reportService;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        reportManager = new ReportManager((ModelMapperService) this.reportService, (ReportRepository) new ModelMapperManager(new ModelMapper()));

    }
    @Test
    @DisplayName("Report Create Successfully Without Any Error")
    public void whenGetByIdCalledWithValidRequest_itShouldReturnValidPatientResponse() throws BusinessException {
        CreateReportRequest createReportRequest = new CreateReportRequest();
        createReportRequest.setDiseaseName("Kalbinde problem var");
        createReportRequest.setDiseaseDetails("Kalp yetmezliği var nabzı çok düşük");
        createReportRequest.setFileNumber(15L);

        boolean result = reportService.add(createReportRequest).isSuccess();

        Assert.assertEquals(true, result);

    }
}