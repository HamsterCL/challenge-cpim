package cl.cpim.prueba;

import cl.cpim.prueba.entity.Phone;
import cl.cpim.prueba.entity.User;
import cl.cpim.prueba.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceTest {
	@Autowired
	private UserService userService;

	@Test
	void testUserRegistration() throws Exception {
		User user = new User();
		user.setName("Juan Rodriguez");
		user.setEmail("juan@rodriguez.org");
		user.setPassword("Password1");
		Phone phone = new Phone();
		phone.setNumber("123-456-789");
		phone.setNumber("65168163516");
		phone.setCitycode("57");
		phone.setContrycode("1");
		user.setPhones(List.of(phone));

		User savedUser = userService.register(user);

		assertNotNull(savedUser.getId());
		assertEquals("juan@rodriguez.org", savedUser.getEmail());
	}
}

