package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Test;
import episen.pds.citizens.backcitizens.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

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
    public void saveTest(@RequestBody Test test) {
        logger.config("receiving values");
        testService.saveTest(test);
    }
    @PostMapping("/DeleteId/{id}")
    public void deleteTest(@PathVariable int id) {
        logger.config("deleting values");
        testService.deleteTestId(id);
    }
}
