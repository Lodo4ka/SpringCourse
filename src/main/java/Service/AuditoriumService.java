package Service;

import Entity.Auditorium;

import java.util.ArrayList;
import java.util.List;

public class AuditoriumService implements Service<Auditorium> {

    List<Auditorium> auditoriums;

    public AuditoriumService() {
        this.auditoriums = new ArrayList<>();
    }


    public void save(Auditorium auditorium) {
        auditoriums.add(auditorium);
    }


    public void remove(Auditorium auditorium) {
        auditoriums.remove(auditorium);
    }


    @Override
    public List<Auditorium> getAll() {
        return auditoriums;
    }

    @Override
    public Auditorium getByName(String name) {
        for (Auditorium auditorium : auditoriums) {
            if (name.equals(auditorium.getName())) {
                return auditorium;
            }
        }
        return null;
    }


}
