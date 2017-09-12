import Entity.User;
import Service.Service;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    private User user;
    private Service service;


    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ctx.registerShutdownHook();

        ctx.getBean("");
    }
}
