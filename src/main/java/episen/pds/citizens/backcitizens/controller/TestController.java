package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.CitizensBackendApplication;
import episen.pds.citizens.backcitizens.model.Test;
import episen.pds.citizens.backcitizens.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {

    @Autowired
    private TestService testService;
    private static final Logger logger = Logger.getLogger(TestController.class.getName());

    @GetMapping("/Test")
    public Iterable<Test> getTest() {
        logger.config("returning values");
        return testService.getTest();
    }

    @PostMapping("/Form")
    public Test saveTest(Test test) {
        logger.config("receiving values");
        return testService.saveTest(test);
    }
    @PostMapping("/DeleteId")
    public void deleteTest(int Id) {
        logger.config("deleting values");
        testService.deleteTestId(Id);
    }
}
