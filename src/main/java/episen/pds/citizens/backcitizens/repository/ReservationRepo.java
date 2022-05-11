package episen.pds.citizens.backcitizens.repository;


import episen.pds.citizens.backcitizens.model.Messages;
import episen.pds.citizens.backcitizens.model.Reservation;
import episen.pds.citizens.backcitizens.model.architectureModel.Space;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface ReservationRepo extends CrudRepository<Reservation, Integer> {


}