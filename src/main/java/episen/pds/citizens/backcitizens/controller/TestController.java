package episen.pds.citizens.backcitizens.controller;



import episen.pds.citizens.backcitizens.model.Test;
import episen.pds.citizens.backcitizens.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController //spring sert à utiliser le modèle MVC et l'annotation
// sont pour indiquer à spring le role de chaque class
@CrossOrigin(origins = "*", allowedHeaders = "*") //récup sur internet
// autorise le front à récuperer des information par le front sur le back
public class TestController {
    @Override
    public String toString() {
        return "TestController{" +
                "testService=" + testService +
                '}';
    }

    // c'est là qu'à lieu l'interaction avec le front
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
        //return testService.saveTest(test);
    }
    @PostMapping("/DeleteId/{id}")
    public void deleteTest(@PathVariable int id) {
        logger.config("deleting values");
        testService.deleteTestId(id);
    }
}
