package tn.esprit.rh.achat.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.mockito.BDDMockito.*;


@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class OperateurTest {

	
	 @Autowired
	    private MockMvc mockMvc;
	@Mock
	OperateurRepository repo;
	@InjectMocks
	OperateurServiceImpl serv;

	

	@Test
	public void addOperateurTest(){
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new Operateur("orange","op1","111"), new Operateur("Telecom","op2","222")).collect(Collectors.toList()));
	    assertEquals(2, serv.retrieveAllOperateurs().size());
	}
	
	@Test
	public void RetrieveAllTest() {
		List<Operateur> ops = new ArrayList<>();
		ops.add(new Operateur());

		when(repo.findAll()).thenReturn(ops);

		List<Operateur> expected = serv.retrieveAllOperateurs();
		
		
		assertEquals(expected, ops);
		verify(repo).findAll();
	}
	
	// JUnit test for delete employee REST API
    @Test
    public void DeleteTest() throws Exception{
    	Operateur oper = new Operateur();
    	oper.setNom("orangeee");
    	oper.setIdOperateur(1L);
    	oper.setPrenom("or11");
    	oper.setPassword("23322");
    	when(repo.findById(oper.getIdOperateur())).thenReturn(Optional.of(oper));
    	serv.deleteOperateur(oper.getIdOperateur());
    	verify(repo).deleteById(oper.getIdOperateur());
       
    }
	
    @Test()
    public void should_throw_exception_when_user_doesnt_exist()  {
    	Operateur oper = new Operateur();
    	oper.setNom("orangeeezz");
    	oper.setIdOperateur(100L);
    	oper.setPrenom("TEL11");
    	oper.setPassword("0000");
    given(repo.findById(anyLong())).willReturn(Optional.ofNullable(null));
    serv.deleteOperateur(oper.getIdOperateur());
    
   
    }
	


	
}