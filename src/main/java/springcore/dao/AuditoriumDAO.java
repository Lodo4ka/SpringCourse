package springcore.dao;

import springcore.entity.Auditorium;

import java.util.List;

public interface AuditoriumDAO {

    List<Auditorium> getAll();

    Auditorium save(Auditorium auditorium);

    Auditorium add(Auditorium auditorium);

    Auditorium getById(int id);

    void delete(int id);
}
