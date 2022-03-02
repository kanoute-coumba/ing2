package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.controller.MessagesController;
import episen.pds.citizens.backcitizens.model.Messages;

import episen.pds.citizens.backcitizens.repository.MessagesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class MessagesService {

    @Autowired
    private MessagesRepo messagesRepo;


    private static final Logger logger = Logger.getLogger(MessagesController.class.getName());

    public Optional<Messages> getMessagesById(final int id) {
        return messagesRepo.findById(id);
    }

    public Iterable<Messages> getMessagesBySenderAndReceiver(String sender, String receiver) {
        return messagesRepo.findMessageBySender(sender, receiver);
    }

    public Iterable<Messages> getMessages() {
        return messagesRepo.findAll();
    }


    public Messages saveMessage(Messages messages) {
        logger.config("messages send : " + messages.toString());
        return messagesRepo.save(messages);
    }


}

