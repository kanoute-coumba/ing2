package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.controller.UsersController;

import episen.pds.citizens.backcitizens.model.Users;

import episen.pds.citizens.backcitizens.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;


    private static final Logger logger = Logger.getLogger(UsersController.class.getName());

    public Optional<Users> getUserById(final int id) {
        return usersRepo.findById(id);
    }

    public Iterable<Users> getUser() {
        return usersRepo.findAll();
    }


    //public UsersRegistration saveMenuReservation(UsersRegistration usersRegistration) {
    //    logger.config(userRegistration.toString());
    //    return userRegistrationRepo.save(userRegistration);
    //}


}

