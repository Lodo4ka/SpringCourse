package springcore.dao.impl.mapper;

import org.junit.Test;
import springcore.entity.User;

import static org.junit.Assert.*;

public class UserRowMapperTest extends BaseTest{

    @Test
    public void mapRow() throws Exception {
        User user = new User();
        user.setId(1);
        user.setFirstName("Foo");
        user.setLastName("Food");
        user.setEmail("foo@mail.ru");
        user.setPassword("1234");

        assertTrue("User id is null",user.getId() > 0);
    }

}