package com.example.lab.business.concretes;


import com.example.lab.business.abstracts.LaborantService;
import com.example.lab.core.utilities.exceptions.BusinessException;
import com.example.lab.core.utilities.mapping.ModelMapperManager;
import com.example.lab.core.utilities.mapping.ModelMapperService;
import com.example.lab.dataAccess.LaborantRepository;
import com.example.lab.dtos.requests.laborantRequests.CreateLaborantRequest;
import com.example.lab.dtos.responses.GetByIdLaborantResponse;
import com.example.lab.dtos.responses.LaborantListResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LaborantManagerTest {

    LaborantService laborantService;
    LaborantManager laborantManager;
    @Mock
    LaborantRepository laborantRepository;


    @BeforeEach //test senaryosu çalışmadan önce çalıştırılan ilk metot
    public void setUp()  {

      MockitoAnnotations.openMocks(this);
      laborantManager = new LaborantManager(new ModelMapperManager(new ModelMapper()),this.laborantRepository);
    }
    @Test
    @DisplayName("Laborant Create Successfully Without Any Error ")
    public void createLaborantSuccessfully() throws BusinessException {

        CreateLaborantRequest createLaborantRequest = new CreateLaborantRequest();
        createLaborantRequest.setName("Kazım");
        createLaborantRequest.setLastName("Karabekir");
        createLaborantRequest.setHospitalId(5555555L);

        boolean result =laborantService.add(createLaborantRequest).isSuccess();
        Assert.assertEquals(true, result);

    }
}