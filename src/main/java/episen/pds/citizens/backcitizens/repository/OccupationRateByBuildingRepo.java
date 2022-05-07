package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.OccupationRateByBuilding;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationRateByBuildingRepo extends CrudRepository<OccupationRateByBuilding, String> {

    @Query(value = " select year, name_building, rate from OccupationRate where year=2020", nativeQuery=true)

    public Iterable<OccupationRateByBuilding> get2020Rate();

    @Query(value = " select year, name_building, rate from OccupationRate where year=2021", nativeQuery=true)

    public Iterable<OccupationRateByBuilding> get2021Rate();

    @Query(value = " select * from OccupationRate where year=2022", nativeQuery=true)

    public Iterable<OccupationRateByBuilding> get2022Rate();
}
