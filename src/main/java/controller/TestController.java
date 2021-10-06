package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TestService;
import model.Test;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * Read
     * @return - An Iterable object of Employee full filled
     */
    @GetMapping("/Test")
    public Iterable<Test> getTest() {
        return testService.getTest();
    }

}
