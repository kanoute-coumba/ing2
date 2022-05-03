package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Room;
import episen.pds.citizens.backcitizens.model.Tenant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface TenantRepo extends CrudRepository<Tenant, Integer> {

    @Query(value = "select * from tenant", nativeQuery = true)

    public Iterable<Tenant> getAllTenant();

}