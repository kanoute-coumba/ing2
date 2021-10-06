package repository;

import model.Test;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


public class TestRepo {

    @Repository
    public interface Test extends CrudRepository<Test, Integer> {
    }
}
