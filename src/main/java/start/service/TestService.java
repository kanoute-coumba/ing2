package start.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.model.Test;

import start.repository.TestRepo;

import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepo testRepo;

    public Optional<Test> getTestId(final int id) {
        return testRepo.findById(id);
    }

    public Iterable<Test> getTest() {
        return testRepo.findAll();
    }

//    public void deleteTestId(final int id) { testRepo.deleteById(id); }

    public Test saveTest(Test test) {
        return testRepo.save(test);
    }

}

