package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Messages;
import episen.pds.citizens.backcitizens.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MessagesController {


    @Autowired
    private MessagesService messagesService;

    private static final Logger logger = Logger.getLogger(MessagesController.class.getName());

 /*   @PostMapping("/users")
    public void saveMenu(@RequestBody Users users) {
        logger.config("receiving values menu_reservation");
        logger.config(users.toString());
        UsersService.saveMenuReservation(menu_reservation);
    }

  */
 /*   @GetMapping("/cafeteria_reservation")
    public Optional<Menu_reservation> getMenuReservation(@PathVariable int id) {
        logger.config("returning menu values");
        return menuService.getMenuReservation(id);
    } */

    @GetMapping("/messages")
    public Iterable<Messages> getMessages() {
        logger.config("returning values");
        return messagesService.getMessages();
    }

    @GetMapping("/messages/{id}")
    public Optional<Messages> getMessagesById(@PathVariable int id) {
        logger.config("returning menu values");
        //logger.config(Users.toString());
        return messagesService.getMessagesById(id);
    }


    @GetMapping("/messages/sender={sender}/receiver={receiver}")
    public Iterable<Messages> getMessageBySenderAndReceiver(@PathVariable ("sender") String sender, @PathVariable ("receiver") String receiver) {
        logger.config("returning menu values");
        //logger.config(Users.toString());
        return messagesService.getMessagesBySenderAndReceiver(sender, receiver);
    }
}
