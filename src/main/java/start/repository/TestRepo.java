package start.repository;

import org.springframework.data.repository.CrudRepository;
import start.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface TestRepo extends CrudRepository<Test, Integer> {
    }