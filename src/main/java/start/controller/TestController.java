package start.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import start.service.TestService;
import start.model.Test;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * Read
     * @return - An Iterable object of Employee full filled
     */
    @GetMapping("/Test")
    public Iterable<Test> getTest() {
        System.out.println("returning values");
        return testService.getTest();
    }

    @PostMapping("/Form")
    public Test saveTest(Test test) {
        System.out.println("receiving values");
        return testService.saveTest(test);
    }
}
