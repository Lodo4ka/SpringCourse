package Service.impl;

import DAO.InMemmoryDataBaseSimulator;
import Entity.Auditorium;
import Service.AuditoriumService;

import java.util.List;

public class AuditoriumServiceImpl implements AuditoriumService {


    @Override
    public List<Auditorium> getAll() {
     return    InMemmoryDataBaseSimulator.getAuditoriums();
    }

    @Override
    public Auditorium getByName(String name) {
        return  InMemmoryDataBaseSimulator.getAuditoriums().stream().filter(n -> n.getName().equals(name)).findFirst().get();
    }
}
