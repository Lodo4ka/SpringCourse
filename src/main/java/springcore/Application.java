package springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import springcore.dao.UserDAO;
import springcore.entity.Auditorium;
import springcore.entity.Event;
import springcore.entity.User;
import springcore.service.AuditoriumService;
import springcore.service.BookingService;
import springcore.service.EventService;
import springcore.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class Application {

    @Autowired
    private AuditoriumService auditoriumService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserDAO userDAO;

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("springcore");
        ctx.registerShutdownHook();
        ctx.start();

        Application app = ctx.getBean(Application.class);

        User user1 = new User(2, "Sanya", "Zelepukin", "zelepukin@mail.ru", "1234");
        app.userDAO.refresh(user1);

    }

}
