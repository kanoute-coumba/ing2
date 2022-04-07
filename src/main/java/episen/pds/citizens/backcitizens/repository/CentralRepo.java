package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Central;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CentralRepo extends CrudRepository<Central, Integer> {
    @Transactional
    @Modifying
    @Query(value = """
        UPDATE central
        SET state = 'actif'
        WHERE id_building IN :id""", nativeQuery = true)
    void updateStateOfCentral(@Param("id") List<Integer> id);

    @Transactional
    @Modifying
    @Query(value = """
        UPDATE central
        SET state = 'inactif'
        WHERE id_building IN (SELECT id_building
                                FROM building
                                WHERE type_building IN ('solaire', 'eolienne', 'hydraulique', 'thermique'));""", nativeQuery = true)
    void updateResetStateOfCentral();
}