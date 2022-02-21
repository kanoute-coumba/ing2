package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Condition;
import episen.pds.citizens.backcitizens.model.Equipment;
import episen.pds.citizens.backcitizens.model.Messages;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@PropertySource("classpath:sql_queries.properties")
    public interface MessagesRepo extends CrudRepository<Messages, Integer> {

    @Query(value="select * from messages where sender=? and receiver=? order by time", nativeQuery = true)
    Iterable<Messages> findMessageBySender(String sender, String receiver);
}