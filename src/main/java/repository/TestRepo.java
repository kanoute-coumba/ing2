package repository;

import model.Test;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


    @Repository
    public interface TestRepo extends CrudRepository<Test, Integer> {
    }