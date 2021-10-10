package start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import start.service.TestService;
import start.model.Test;

@Controller
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

}
