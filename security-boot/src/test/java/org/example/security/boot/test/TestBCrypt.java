package org.example.security.boot.test;

import org.example.security.boot.SecurityBootApp;
import org.example.security.boot.model.UserDto;
import org.example.security.boot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SecurityBootApp.class)
public class TestBCrypt {

    @Autowired
    UserService service;

    @Test
    public void testBCrypt() {
        String hashpw = BCrypt.hashpw("456",BCrypt.gensalt());
        System.out.println(hashpw);

        boolean b = BCrypt.checkpw("123","$2a$10$S.nufo./NX4RRx2qt5p/wO35sevH.l3/e2/m9m2UPw7wP4V3tS6jG");
        System.out.println(b);
    }

    @Test
    public void a() {

        UserDto userDto1 = new UserDto();
        userDto1.setUsername("zhangsan");
        userDto1.setPassword("$2a$10$S.nufo./NX4RRx2qt5p/wO35sevH.l3/e2/m9m2UPw7wP4V3tS6jG");
        userDto1.setFullName("张三");
        userDto1.setMobile("133455");

        UserDto userDto2 = new UserDto();
        userDto2.setUsername("lisi");
        userDto2.setPassword("$2a$10$2YRSQcIWtG7x2e2CImdPaOlGqQ5HiVk90I11xtG0L9TK5KEEPEtmO");
        userDto2.setFullName("李四");

        service.createUser(userDto2);
    }
}
