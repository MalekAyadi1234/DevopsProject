package tn.esprit.rh.achat.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.User;
import tn.esprit.rh.achat.repositories.UserRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class UserServiceImplMock {
	@Mock
	//UserRepository userRepository;
	// Ou
	UserRepository userRepository = Mockito.mock(UserRepository.class);
	
	@InjectMocks
	UserServiceImpl userService;

	User user = new User("f1", "l1", new Date());
	List<User> listUsers = new ArrayList<User>() {
	{
	add(new User("f2", "l2", new Date()));
	add(new User("f3", "l3", new Date()));
	}
	
	};
	
	@Test
	public void testRetrieveUser() {
	Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
	User user1 = userService.retrieveUser("2");
	Assertions.assertNotNull(user1);
	}
	
	
}
