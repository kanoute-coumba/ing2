package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Condition;
import episen.pds.citizens.backcitizens.model.Messages;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@PropertySource("classpath:sql_queries.properties")
    public interface MessagesRepo extends CrudRepository<Messages, Integer> {

    @Query(value="select * from messages where (sender=?1 and receiver=?2) or (receiver=?1 and sender=?2) order by time", nativeQuery = true)
    Iterable<Messages> findMessageBySender(String sender, String receiver);
}