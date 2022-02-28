package episen.pds.citizens.backcitizens.repository;


import episen.pds.citizens.backcitizens.model.Menu_reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface MenuReservationRepo extends CrudRepository<Menu_reservation, Integer> {
}