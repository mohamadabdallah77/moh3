package fr.plil.sio.web.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        userService.createUser("blabla", "polo");
        User u = userRepository.findByUsername("blabla");
        assertEquals("blabla", u.getUsername());
        assertEquals(1, u.getRoles().size());
        assertEquals("ROLE_USER", u.getRoles().iterator().next().getName());
    }
}
