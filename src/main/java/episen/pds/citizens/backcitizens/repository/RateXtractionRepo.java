package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.RateXtraction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RateXtractionRepo extends CrudRepository<RateXtraction, Integer> {

        @Transactional
        @Modifying
        @Query(value = " create table if not exists RateXtraction as (select rentcounterbyyear.year, " +
                "rentcounterbyyear.name_building, DWPbyBuilding.nbredwps, " +
                "rentcounterbyyear.counter from DWPbyBuilding inner join rentcounterbyyear " +
                "on DWPbyBuilding.name_building=rentcounterbyyear.name_building " +
                "group by rentcounterbyyear.year, rentcounterbyyear.name_building, " +
                "DWPbyBuilding.nbredwps, rentcounterbyyear.counter " +
                "order by rentcounterbyyear.year)", nativeQuery = true)

        public void createRateXtraction();

        @Transactional
        @Modifying
        @Query(value = " create table if not exists OccupationRate as (select year, name_building, " +
                "((100*counter)/(nbredwps*365)) as rate from RateXtraction)", nativeQuery = true)

        public void getRateXtraction();

        }


