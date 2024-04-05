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
import app.entity.Produto;
import app.repository.ClienteRepository;

@SpringBootTest
public class ClienteControllerTest {
	@Autowired
	ClienteController clienteController;
	
	@MockBean
	ClienteRepository clienteRepository;
	
	@BeforeEach
	void setup(){
		
		List<Cliente> list = new ArrayList<>();
		list.add(new Cliente(1, "joao", "1123123123", 12, "559123123123", null));
		list.add(new Cliente(2, "maria", "994920100123", 21, "9011239", null));
		Cliente cliente = new Cliente(3, "joao", "77718239123", 12, "00123899123", null);
		
		when(this.clienteRepository.save(cliente)).thenReturn(cliente);
		when(this.clienteRepository.findAll()).thenReturn(list);
		when(this.clienteRepository.findById(3L)).thenReturn(Optional.of(cliente));
		
	}
	
	@Test
	@DisplayName("FINDALL CLIENTE")
	void cenario1() {
		
		ResponseEntity<List<Cliente>> response = this.clienteController.listAll();
		List<Cliente> list = response.getBody();
		
		assertEquals(2, list.size());
		assertEquals("joao", list.get(0).getNome());
		
	}
	
	@Test
	@DisplayName("SAVE CLIENTE")
	void cenario2() {
		Cliente cliente = new Cliente(4, "carlos", "77718239123", 12, "00123899123", null);
		
		ResponseEntity<String> response = this.clienteController.save(cliente);
		String mensagem = response.getBody();
		
		assertEquals(cliente, cliente);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("carlos Foi registrado", mensagem);
	}
	
	@Test
	@DisplayName("SAVE MOCK EXCEPTION")
	void cenario3() {
		
		Cliente cliente = null;
		ResponseEntity<String> response = this.clienteController.save(cliente);

		assertEquals(HttpStatus.BAD_GATEWAY, response.getStatusCode());
	}
	
	@Test
	@DisplayName("FINDBYID MOCK")
	void cenario4() {
		
		ResponseEntity<Cliente> response = this.clienteController.findById(3L);
		Cliente cliente = response.getBody();
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals("joao", cliente.getNome());
		
	}
	
	@Test
	@DisplayName("FINDBYID MOCK EXCEPTION")
	void cenario5() {
		
		ResponseEntity<Cliente> response = this.clienteController.findById(9L);
		
		assertEquals(HttpStatus.BAD_GATEWAY, response.getStatusCode());
		
	}
	
	@Test
	@DisplayName("FINDBYNOME")
	void cenario6() {
		
		List<Cliente> list = new ArrayList<>();
		list.add(new Cliente(1, "joao", "77718239123", 12, "00123899123", null));
		list.add(new Cliente(2, "maria", "994920100123", 21, "9011239", null));
		
		ResponseEntity<List<Cliente>> response = this.clienteController.findByNome("joao");
		//List<Produto> produto = response.getBody();
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		//assertEquals(2L, list.get(1).getIdProduto());
		//assertEquals(list.get(1), response.getBody());
		
	}
	
	@Test
	@DisplayName("FINDBYCPF")
	void cenario7() {
		
		List<Cliente> list = new ArrayList<>();
		list.add(new Cliente(1, "joao", "77718239123", 12, "00123899123", null));
		list.add(new Cliente(2, "maria", "994920100123", 21, "9011239", null));
		
		ResponseEntity<List<Cliente>> response = this.clienteController.findByCpf("77718239123");
		//List<Produto> produto = response.getBody();
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		//assertEquals(2L, list.get(1).getIdProduto());
		//assertEquals(list.get(1), response.getBody());
		
	}
	
}
