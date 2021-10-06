package service;

import model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import repository.TestRepo;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public class TestService {

    @Autowired
    private TestRepo testRepo;

    public Optional<Test> getTestId(final int id) {
        return testRepo.findById(id);
    }

    public Iterable<Test> getTest() {
        return testRepo.findAll();
    }

    public void deleteTestId(final int id) {
        testRepo.deleteById(id);
    }

    public Test saveEmployee(Test test) {
        Test savedEmployee = testRepo.save(test);
        return savedEmployee;
    }

}
}
