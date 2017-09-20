package springcore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import springcore.dao.AuditoriumDAO;
import springcore.entity.Auditorium;


@Service
public class AuditoriumDAOImpl implements AuditoriumDAO{




    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AuditoriumDAOImpl() {
    }

    @Override
    public Auditorium read(Auditorium auditorium) {
        return null;
    }
}
