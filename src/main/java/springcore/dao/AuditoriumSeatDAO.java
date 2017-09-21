package springcore.dao;

import springcore.entity.Auditorium;
import springcore.entity.AuditoriumSeat;
import springcore.enums.TypeofSeat;

import java.util.List;

public interface AuditoriumSeatDAO {

    List<AuditoriumSeat> getAll();

    List<AuditoriumSeat> getByAuditorium(Auditorium auditorium);

    List<AuditoriumSeat> getByTypeOfSeat(TypeofSeat typeofSeat);

    AuditoriumSeat add(AuditoriumSeat auditoriumSeat);

    AuditoriumSeat save(AuditoriumSeat auditoriumSeat);

    AuditoriumSeat getById(int id);

    void delete(int id);
}
