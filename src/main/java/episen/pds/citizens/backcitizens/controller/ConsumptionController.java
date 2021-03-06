package episen.pds.citizens.backcitizens.controller;


import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.service.ConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConsumptionController {

    private static final Logger logger = Logger.getLogger(ConsumptionController.class.getName());
    @Autowired
    ConsumptionService consumptionService;


    @GetMapping("/ConsumptionEquipment/{ide}")
    public Iterable<Consumption> findHistoryConsumptionByIdEquipment(@PathVariable("ide") String id_e){
        logger.info("findHistoryConsumptionByIdEquipment");
        return consumptionService.findHistoryConsumptionByIdEquipment(id_e);
    }
    @GetMapping("/ConsumptionEquipment/{ide}/Between/{dBegin}&{dEnd}")
    public Iterable<Consumption> findHistoryConsumptionByIdEquipmentBetweenTwoDate(@PathVariable("ide") String id_e,
                                                                                   @PathVariable("dBegin")long dBegin,
                                                                                   @PathVariable("dEnd") long dEnd){
        logger.info("findHistoryConsumptionByIdEquipmentBetweenTwoDate");
        return consumptionService.findHistoryConsumptionByIdEquipmentBetweenTwoDate(id_e,dBegin,dEnd);
    }
    @GetMapping("/ConsumptionRoom/{idr}/Between/{dBegin}&{dEnd}")
    public Iterable<Consumption> findHistoryConsumptionByIdRoomBetweenTwoDate(@PathVariable("idr") String id_r,
                                                                                   @PathVariable("dBegin")long dBegin,
                                                                                   @PathVariable("dEnd") long dEnd){
        logger.info("findHistoryConsumptionByIdRoomBetweenTwoDate");
        return consumptionService.findHistoryConsumptionByIdRoomBetweenTwoDate(id_r,dBegin,dEnd);
    }
    @GetMapping("/ConsumptionFloor/{idf}/Between/{dBegin}&{dEnd}")
    public Iterable<Consumption> findHistoryConsumptionByIdFloorBetweenTwoDate(@PathVariable("idf") String id_f,
                                                                              @PathVariable("dBegin")long dBegin,
                                                                              @PathVariable("dEnd") long dEnd){
        logger.info("findHistoryConsumptionByIdFloorBetweenTwoDate");
        return consumptionService.findHistoryConsumptionByIdFloorBetweenTwoDate(id_f,dBegin,dEnd);
    }
    @GetMapping("/ConsumptionBuilding/{idb}/Between/{dBegin}&{dEnd}")
    public Iterable<Consumption> findHistoryConsumptionByIdBuildingBetweenTwoDate(@PathVariable("idb") String id_b,
                                                                              @PathVariable("dBegin")long dBegin,
                                                                              @PathVariable("dEnd") long dEnd){
        logger.info("findHistoryConsumptionByIdBuildingBetweenTwoDate");
        return consumptionService.findHistoryConsumptionByIdBuildingBetweenTwoDate(id_b,dBegin,dEnd);
    }
    @GetMapping("/ConsumptionByIdBuildingNow/{idb}")
    public Consumption ConsumptionByIdBuildingNow(@PathVariable("idb") int idb){
        return consumptionService.consumptionByIdBuildingNow(idb);
    }
    @GetMapping("/ConsumptionByIdRoomNow/{idr}")
    public Consumption ConsumptionByIdRoomNow(@PathVariable("idr") int idr){
        return consumptionService.consumptionByIdRoomNow(idr);
    }
}
