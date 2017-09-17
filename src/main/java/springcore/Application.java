package springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import springcore.dao.InMemmoryDataBaseSimulator;
import springcore.entity.Auditorium;
import springcore.entity.Event;
import springcore.entity.Ticket;
import springcore.entity.User;
import springcore.service.AuditoriumService;
import springcore.service.BookingService;
import springcore.service.EventService;
import springcore.service.UserService;
import springcore.service.impl.AuditoriumServiceImpl;
import springcore.service.impl.BookingServiceImpl;
import springcore.service.impl.EventServiceImpl;
import springcore.service.impl.UserServiceImpl;

import java.time.LocalDateTime;
import java.time.Month;
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

    public static void main(String[] args) {

        InMemmoryDataBaseSimulator inMemmoryDataBaseSimulator = new InMemmoryDataBaseSimulator();
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("springcore");
        ctx.registerShutdownHook();
        ctx.start();

        Application app = ctx.getBean(Application.class);


        app.userService.save(new User(1, "Danila", "Bodrov", "danila@mail.ru", "1234"));
        app.eventService.save(new Event("Premier", 1, 20, LocalDateTime.now()));


        List<Event> events = app.eventService.getAll();
        List<User> users = app.userService.getAll();
        List<Auditorium> auditoriums = app.auditoriumService.getAll();

        users.forEach(System.out::println);
        System.out.println("----------------------");
        events.forEach(System.out::println);
        System.out.println("----------------------");
        auditoriums.forEach(System.out::println);
    }

}
