package com.yellow.photoshare;

import com.yellow.photoshare.dao.UserDAO;
import com.yellow.photoshare.entity.UserEntity;
import com.yellow.photoshare.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class UsersTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserService();
        }

        @Bean
        public UserDAO userDAO() {
            return new UserDAO();
        }
    }

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        UserEntity userEntity = new UserEntity("Igor", "fox0234@yandex.ru", "Swift power - Java ...", "Swift power - Java ...");
        Assert.assertTrue(userService.addPerson(userEntity));
    }
}
