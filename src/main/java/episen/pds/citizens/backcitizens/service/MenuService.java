package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Menu;
import episen.pds.citizens.backcitizens.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepo menuRepo;

    public Optional<Menu> getMenuById(final int id) {
        return menuRepo.findById(id);
    }

    public Iterable<Menu> getMenu() {
        return menuRepo.findAll();
    }


}

