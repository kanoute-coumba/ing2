package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.model.*;
import episen.pds.citizens.backcitizens.repository.*;
import episen.pds.citizens.backcitizens.service.OccupationService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class OccupationServiceTest extends TestCase {

    @InjectMocks
    private OccupationService occupationService;

    @Mock
    private RentCounterByYearRepo rentCounterByYearRepo;

    @Mock
    private DWPbyBuildingRepo dwpByBuildingRepo;
    @Mock
    private OccupationRateRepo occupationRateRepo;
    @Mock
    private OccupationRateByBuildingRepo occupationRateByBuildingRepo;


    @Test
    public void testGetRentCounterByYear() {

                //GIVEN
                Iterable<RentCounterByYear> expectedRent = rentCounterByYearRepo.getRentCounterByYear();
                //WHEN
                Iterable<RentCounterByYear> savedRent = occupationService.getRentCounterByYear();

                assertNotNull(expectedRent);
                assertNotNull(savedRent);
                //THEN
                assertEquals(expectedRent,savedRent);

    }

    @Test
    public void testGetDWPbuildings() {

                //GIVEN
                Iterable<DWPbyBuilding> expectedDWP = dwpByBuildingRepo.getDWPbuildings();
                //WHEN
                Iterable<DWPbyBuilding> savedDWP = occupationService.getDWPbuildings();
                assertNotNull(expectedDWP);
                assertNotNull(savedDWP);
                //THEN
                assertEquals(expectedDWP, savedDWP);

    }

    @Test
    public void testGetOccupationRate() {

                //GIVEN
                Iterable<OccupationRate> expectedOccupationRate = occupationRateRepo.getOccupationRate();
                //WHEN
                Iterable<OccupationRate> savedOccupationRate = occupationService.getOccupationRate();
                assertNotNull(expectedOccupationRate);
                assertNotNull(savedOccupationRate);
                //THEN
                assertEquals(expectedOccupationRate, savedOccupationRate);

    }

    @Test
    public void testGet2020Rate() {

                //GIVEN
                Iterable<OccupationRateByBuilding> expectedRate1 = occupationRateByBuildingRepo.get2020Rate();
                //WHEN
                Iterable<OccupationRateByBuilding> savedRate1 = occupationService.get2020Rate();
                assertNotNull(expectedRate1);
                assertNotNull(savedRate1);
                //THEN
                assertEquals(expectedRate1, savedRate1);

    }

    @Test
    public void testGet2021Rate() {

                //GIVEN
                Iterable<OccupationRateByBuilding> expectedRate2 = occupationRateByBuildingRepo.get2021Rate();
                //WHEN
                Iterable<OccupationRateByBuilding> savedRate2 = occupationService.get2021Rate();
                assertNotNull(expectedRate2);
                assertNotNull(savedRate2);
                //THEN
                assertEquals(expectedRate2, savedRate2);

    }

    @Test
    public void testGet2022Rate() {

                Iterable<OccupationRateByBuilding> expectedRate3 = occupationRateByBuildingRepo.get2022Rate();
                //WHEN
                Iterable<OccupationRateByBuilding> savedRate3 = occupationService.get2022Rate();
                assertNotNull(expectedRate3);
                assertNotNull(savedRate3);
                //THEN
                assertEquals(expectedRate3, savedRate3);

    }
}