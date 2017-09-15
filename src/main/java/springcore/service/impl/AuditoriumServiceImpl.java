package springcore.service.impl;

import org.springframework.stereotype.Service;
import springcore.dao.InMemmoryDataBaseSimulator;
import springcore.entity.Auditorium;
import springcore.service.AuditoriumService;

import java.util.List;


@Service
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
