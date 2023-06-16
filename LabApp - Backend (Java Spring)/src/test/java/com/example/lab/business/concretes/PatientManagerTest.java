package com.example.lab.business.concretes;

import com.example.lab.business.abstracts.PatientService;
import com.example.lab.core.utilities.exceptions.BusinessException;
import com.example.lab.core.utilities.mapping.ModelMapperManager;
import com.example.lab.core.utilities.mapping.ModelMapperService;
import com.example.lab.dataAccess.PatientRepository;
import com.example.lab.dtos.requests.laborantRequests.CreateLaborantRequest;
import com.example.lab.dtos.requests.patientRequests.CreatePatientRequest;
import com.example.lab.dtos.responses.GetByIdReportResponse;
import com.example.lab.dtos.responses.PatientListResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PatientManagerTest {

    PatientManager patientManager;
    @Mock
    PatientService patientService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        patientManager = new PatientManager((ModelMapperService)
                this.patientService, (PatientRepository) new ModelMapperManager(new ModelMapper()));

    }
    @Test
    @DisplayName("Patient Create Successfully Without Any Error")
    public void whenGetByIdCalledWithValidRequest_itShouldReturnValidPatientResponse() throws BusinessException {

        CreatePatientRequest createPatientRequest = new CreatePatientRequest();
        createPatientRequest.setFirstName("Bekir");
        createPatientRequest.setLastName("Kazım");
        createPatientRequest.setIdentificationNumber("123345152798");

        boolean result = patientService.add(createPatientRequest).isSuccess();

        Assert.assertEquals(true, result);

    }
    }
