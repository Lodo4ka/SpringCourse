package springcore.service;

import springcore.entity.Auditorium;

import java.util.List;

public interface AuditoriumService {


    List<Auditorium> getAll();

    Auditorium getByName(String name);

}
