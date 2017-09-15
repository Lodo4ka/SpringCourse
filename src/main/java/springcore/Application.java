package springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import springcore.entity.Auditorium;
import springcore.service.AuditoriumService;
import springcore.service.impl.AuditoriumServiceImpl;

import java.util.List;

@Component
public class Application {

    @Autowired
    private AuditoriumService auditoriumService;

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("springcore");
        ctx.registerShutdownHook();
        ctx.start();

        Application app = ctx.getBean(Application.class);

        List<Auditorium> auditoriums = app.auditoriumService.getAll();

        auditoriums.forEach(System.out::println);
    }


}
