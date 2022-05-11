package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.ChoiceAlgo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceAlgoRepo extends CrudRepository<ChoiceAlgo,Integer> {

    @Query(value="select * from choice_algo order by id_choice_algo desc limit 1;", nativeQuery = true)
    public ChoiceAlgo getChoiceAlgo();
}
