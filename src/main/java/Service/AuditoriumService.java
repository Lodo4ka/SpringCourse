package Service;

import Entity.Auditorium;

import java.util.ArrayList;
import java.util.List;

public interface AuditoriumService {


    List<Auditorium> getAll();

    Auditorium getByName(String name);

}
