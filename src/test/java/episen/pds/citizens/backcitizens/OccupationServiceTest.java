package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.model.*;
import episen.pds.citizens.backcitizens.repository.*;
import episen.pds.citizens.backcitizens.service.OccupationService;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
class OccupationServiceTest extends TestCase {

    @Mock
    RentCounterByYearRepo rentCounterByYearRepo;
    @Mock
    DWPbyBuildingRepo dwpByBuildingRepo;
    @Mock
    private TenantDetailsRepo tenantDetailsRepo;
    @Mock
    private OccupationRateRepo occupationRateRepo;
    @Mock
    private OccupationRateByBuildingRepo occupationRateByBuildingRepo;

    @InjectMocks
    private OccupationService occupationService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getRentCounterByYear() {

        while (occupationService!=null) {

            if (rentCounterByYearRepo!=null) {

                Iterable<RentCounterByYear> savedRent = occupationService.getRentCounterByYear();
                Iterable<RentCounterByYear> expectedRent = rentCounterByYearRepo.getRentCounterByYear();
                assertNotNull(expectedRent);
                assertNotNull(savedRent);
                Assert.assertEquals(expectedRent,savedRent);
            }
        }
    }

    @Test
    void getDWPbuildings() {

        while (occupationService!=null) {

            if (dwpByBuildingRepo != null) {

                Iterable<DWPbyBuilding> expectedDWP = dwpByBuildingRepo.getDWPbuildings();
                Iterable<DWPbyBuilding> savedDWP = occupationService.getDWPbuildings();
                assertNotNull(expectedDWP);
                assertNotNull(savedDWP);
                Assert.assertEquals(expectedDWP, savedDWP);
            }
        }
    }

    @Test
    void getTenantDetails() {
        while (occupationService!=null) {

            if (tenantDetailsRepo != null) {

                Iterable<TenantDetails> expectedTd = tenantDetailsRepo.getTenantDetails();
                Iterable<TenantDetails> savedTd = occupationService.getTenantDetails();
                assertNotNull(expectedTd);
                assertNotNull(savedTd);
                Assert.assertEquals(expectedTd, savedTd);
            }
        }
    }

    @Test
    void getOccupationRate() {

        while (occupationService!=null) {

            if (dwpByBuildingRepo != null) {

                Iterable<OccupationRate> expectedOccupationRate = occupationRateRepo.getOccupationRate();
                Iterable<OccupationRate> savedOccupationRate = occupationService.getOccupationRate();
                assertNotNull(expectedOccupationRate);
                assertNotNull(savedOccupationRate);
                Assert.assertEquals(expectedOccupationRate, savedOccupationRate);
            }
        }

    }

    @Test
    void get2020Rate() {
        while (occupationService!=null) {

            if (tenantDetailsRepo != null) {

                Iterable<OccupationRateByBuilding> expectedRate1 = occupationRateByBuildingRepo.get2020Rate();
                Iterable<OccupationRateByBuilding> savedRate1 = occupationService.get2020Rate();
                assertNotNull(expectedRate1);
                assertNotNull(savedRate1);
                Assert.assertEquals(expectedRate1, savedRate1);
            }
        }

    }

    @Test
    void get2021Rate() {

        while (occupationService!=null) {

            if (tenantDetailsRepo != null) {

                Iterable<OccupationRateByBuilding> expectedRate2 = occupationRateByBuildingRepo.get2021Rate();
                Iterable<OccupationRateByBuilding> savedRate2 = occupationService.get2021Rate();
                assertNotNull(expectedRate2);
                assertNotNull(savedRate2);
                Assert.assertEquals(expectedRate2, savedRate2);
            }
        }
    }

    @Test
    void get2022Rate() {

        while (occupationService!=null) {

            if (tenantDetailsRepo != null) {

                Iterable<OccupationRateByBuilding> expectedRate3 = occupationRateByBuildingRepo.get2022Rate();
                Iterable<OccupationRateByBuilding> savedRate3 = occupationService.get2022Rate();
                assertNotNull(expectedRate3);
                assertNotNull(savedRate3);
                Assert.assertEquals(expectedRate3, savedRate3);
            }
        }
    }
}