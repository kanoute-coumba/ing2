package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Messages;
import episen.pds.citizens.backcitizens.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MessagesController {


    @Autowired
    private MessagesService messagesService;

    private static final Logger logger = Logger.getLogger(MessagesController.class.getName());

//   @PostMapping("/messages")
//    public void saveMessage(@RequestBody Messages messages) {
//        logger.config("receiving values message");
//        logger.config(messages.toString());
//        messagesService.saveMessage(messages);
//    }

    @RequestMapping(value = "/messages",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            //produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public void saveMessage(@RequestBody Messages messages) {
        logger.config("receiving values message");
        logger.config(messages.toString());
        messagesService.saveMessage(messages);
    }





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
