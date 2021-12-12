package episen.pds.citizens.backcitizens.repository;


import episen.pds.citizens.backcitizens.model.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface MenuRepo extends CrudRepository<Menu, Integer> {
}