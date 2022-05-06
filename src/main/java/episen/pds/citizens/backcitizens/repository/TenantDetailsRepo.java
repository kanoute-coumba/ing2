package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.TenantDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface TenantDetailsRepo extends CrudRepository<TenantDetails, Date> {

    @Transactional
    @Modifying
    @Query(value = "create table if not exists tenantdetails as select A1.date, company.name_company, " +
            "A1.type_space, A1.name_floor, A1.name_building from company INNER JOIN " +
            "(select tenant.id_space, tenant.id_company, tenant.date, workplace.type_space, " +
            "workplace.name_floor, workplace.name_building from tenant inner join workplace " +
            "on tenant.id_space=workplace.id_space) as A1 on A1.id_company=company.id_company order by A1.date", nativeQuery = true)

    public void createTenantDetails();

    @Query(value = " select * from tenantdetails", nativeQuery = true)
    public Iterable<TenantDetails> getTenantDetails();

}
