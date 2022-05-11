package episen.pds.citizens.backcitizens.repository;


import com.sun.istack.Nullable;
import episen.pds.citizens.backcitizens.model.Messages;
import episen.pds.citizens.backcitizens.model.RSpace;
import episen.pds.citizens.backcitizens.model.architectureModel.Space;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface SpacesRepo extends CrudRepository<RSpace, Integer> {

    //@Query(value="select users.user_id, username, right_layer, type, name_space, type_space, id_floor, reservation_id, start_time, end_time from space inner join reservation on space.id_space=reservation.id_space inner join users on users.user_id=reservation.user_id;", nativeQuery = true)
    @Query(value="select * from space inner join reservation on space.id_space=reservation.id_space inner join users on users.user_id=reservation.user_id;", nativeQuery = true)
    Iterable<RSpace> findReservedSpaces();

    //@Nullable
    @Query(value="select * from space " +
            "inner join floor on space.id_floor = floor.id_floor " +
            "inner join building on building.id_building = floor.id_building " +
            "inner join userbuilding on building.id_building = userbuilding.id_building  " +
            "where space.type_space=?3 and userbuilding.id_user=?4 and " +
            "id_space not in " +
            "(Select id_space from reservation where " +
            "(start_time <= ?2) and (end_time >= ?1));", nativeQuery = true)
    Iterable<RSpace> findDispoSpaces(long starttime, long endtime, String typespace, int iduser);

    /* @Query(value="select space.* from space inner join reservation on space.id_space = reservation.id_space " +
            "inner join floor on space.id_floor = floor.id_floor " +
            "inner join building on building.id_building = floor.id_building " +
            "inner join userbuilding on building.id_building = userbuilding.id_building " +
            "where start_time not between ?1 and ?2 and end_time not between ?1 and ?2 and space.type_space=?3 and userbuilding.id_user=?4 limit 10;", nativeQuery = true)
    Iterable<RSpace> findDispoSpaces(long starttime, long endtime, String typespace, int iduser);


       /*     "select * from space inner join reservation on space.id_space = reservation.id_space "
            + "inner join floor on space.id_floor = floor.id_floor inner join userbuilding on building.id_building = userbuilding.id_building "
            + "inner join building on building.id_building = floor.id_building where start_time not between ?1"+" and ?2"+" end_time not between ?1"+" and ?2 "
            + "and space.type_space=?3 and userbuilding.id_user=?4 limit 10;", nativeQuery = true)
    Iterable<RSpace> findDispoSpaces(long starttime, long endtime, String typespace, int iduser);*/
}