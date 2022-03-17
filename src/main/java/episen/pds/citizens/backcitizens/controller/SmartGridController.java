package episen.pds.citizens.backcitizens.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SmartGridController {

    @GetMapping("/smartgrid")
    public Double smartgrid() {
        return random(-500, 10);
    }

    private static double random(double mean, double sigma) {
        Random random = new Random();
        double value = (random.nextGaussian()  * sigma) + mean;
        return Math.round(value * 100.0) / 100.0;
    }
}
