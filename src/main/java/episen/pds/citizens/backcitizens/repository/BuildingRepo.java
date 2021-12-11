package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Building;
import episen.pds.citizens.backcitizens.model.EquipmentWithConsumption;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepo extends CrudRepository<Building, Integer> {

    @Query(value = "SELECT building.*, consumption, production FROM building FULL JOIN (SELECT id_building, SUM(consumptionByFloor) as consumption FROM floor FULL JOIN (SELECT id_floor, SUM(consumptionByRoom) as consumptionByFloor FROM room FULL JOIN (SELECT id_room, SUM(consumptionByEquipment) as consumptionByRoom FROM equipment FULL JOIN (SELECT id_equipment, SUM(value) as consumptionByEquipment FROM consumption GROUP BY id_equipment) as c1 on c1.id_equipment = equipment.id_equipment GROUP BY id_room) as c2 on c2.id_room = room.id_room GROUP BY id_floor) as c3 on c3.id_floor = floor.id_floor GROUP BY id_building) as c4 on c4.id_building = building.id_building FULL JOIN (SELECT id_building, SUM(productionByCentral) as production FROM central FUll JOIN (SELECT id_central, SUM(value) as productionByCentral FROM production GROUP BY id_central) as c5 on c5.id_central = central.id_central GROUP BY id_building) as c6 on c6.id_building = building.id_building ORDER BY building.id_building", nativeQuery = true)
    public Iterable<Building> findAll();
}
