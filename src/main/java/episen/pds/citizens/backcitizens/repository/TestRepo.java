package episen.pds.citizens.backcitizens.repository;


import episen.pds.citizens.backcitizens.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface TestRepo extends JpaRepository<Test, Integer> {
    }