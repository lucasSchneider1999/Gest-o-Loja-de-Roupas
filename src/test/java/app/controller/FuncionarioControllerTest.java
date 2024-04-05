package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.entity.Cliente;
import app.entity.Funcionario;
import app.repository.FuncionarioRepository;

@SpringBootTest

public class FuncionarioControllerTest {

	@Autowired
	FuncionarioControlller funcionarioController;
	
	@MockBean
	FuncionarioRepository funcionarioRepository;
	
	@BeforeEach
	void setup(){
		List<Funcionario> lista = new ArrayList<>();
		lista.add(new Funcionario (1, "Jose", 25, "244", null));
		lista.add(new Funcionario(2, "Ricardo", 34, "333", null));
		Funcionario funcionario = new Funcionario(3, "Jose Ricardo", 35, "2444", null);
		

		
		when(this.funcionarioRepository.findAll()).thenReturn(lista);
		when(this.funcionarioRepository.save(funcionario)).thenReturn(funcionario);
		when(this.funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionario));
	}
	
	@Test
	@DisplayName("FINDALL FUNCIONARIO")
	void cenario1() {
		
		ResponseEntity<List<Funcionario>> response = this.funcionarioController.listAll();
		List<Funcionario> list = response.getBody();
		
		assertEquals(2, list.size());
		assertEquals("Jose", list.get(0).getNome());
		
	}
	
	@Test
	@DisplayName("SAVE FUNCIONARIO")
	void cenario2() {
		Funcionario funcionario = new Funcionario(3, "Jose Ricardo", 35, "2444", null);
		
		ResponseEntity<String> response = this.funcionarioController.save(funcionario);
		String mensagem = response.getBody();
		
		assertEquals(funcionario, funcionario);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	@Test
	@DisplayName("SAVE MOCK EXCEPTION")
	void cenario3() {
		
		Funcionario funcionario = null;
		ResponseEntity<String> response = this.funcionarioController.save(funcionario);

		assertEquals(HttpStatus.BAD_GATEWAY, response.getStatusCode());
	}
	
	@Test
	@DisplayName("FINDBYID MOCK EXCEPTION")
	void cenario5() {
		
		ResponseEntity<Funcionario> response = this.funcionarioController.findById(9L);
		
		assertEquals(HttpStatus.BAD_GATEWAY, response.getStatusCode());
		
	}
	
	
	@Test
	@DisplayName("FINDBYNOME")
	void cenario6() {
		
		List<Funcionario> list = new ArrayList<>();
		list.add(new Funcionario (1, "Jose", 25, "244", null));
		list.add(new Funcionario(2, "Ricardo", 34, "333", null));
		
		ResponseEntity<List<Funcionario>> response = this.funcionarioController.findByNome("Jose");
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	
		
	}
	

	@Test
	@DisplayName("FINDBYID MOCK EXCEPTION")
	void cenario7() {
		
		ResponseEntity<Funcionario> response = this.funcionarioController.findById(9L);
		
		assertEquals(HttpStatus.BAD_GATEWAY, response.getStatusCode());
		
	}
}
