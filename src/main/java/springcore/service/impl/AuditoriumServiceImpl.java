package springcore.service.impl;

import org.springframework.stereotype.Service;
import springcore.dao.InMemmoryDataBaseSimulator;
import springcore.entity.Auditorium;
import springcore.service.AuditoriumService;

import java.util.List;
import java.util.Optional;


@Service
public class  AuditoriumServiceImpl implements AuditoriumService {


    @Override
    public List<Auditorium> getAll() {
     return    InMemmoryDataBaseSimulator.getAuditoriums();
    }

    @Override
    public Auditorium getByName(String name) {
        Optional<Auditorium> auditoriumOptional = InMemmoryDataBaseSimulator.getAuditoriums().stream().filter(n -> n.getName().equals(name)).findFirst();

        return auditoriumOptional.orElse(new Auditorium());
    }
}
