package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
    public interface CompanyRepo extends CrudRepository<Company, Integer> {

    @Query(value = " ***** ", nativeQuery=true)

    public Iterable<Company> findPeakDay();


}
