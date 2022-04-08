package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Tenant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TenantRepo extends CrudRepository<Tenant, Integer> {


    @Query(value = " ******* ", nativeQuery = true)

    public Iterable<Tenant> getTenant();
}