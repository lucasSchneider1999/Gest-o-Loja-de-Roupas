package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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

import app.entity.Venda;
import app.repository.VendaRepository;

@SpringBootTest
public class VendaControllerTest {

		@Autowired
		VendaController vendaController;
		
		@MockBean
		VendaRepository vendaRepository;
		
		@BeforeEach
		void setup() {
			
			List<Venda> lista = new ArrayList<>();
			lista.add(new Venda(1, "asdasd", 3.55, 2.44, "OK", null, null, null));
			lista.add(new Venda(2, "qweeqweqq", 7.55, 1.33, "CANCELADA", null, null, null));
			Venda venda = new Venda(3, "venda1", 3.55, 2.44, "OK", null, null, null);
			
	
			
			when(this.vendaRepository.findAll()).thenReturn(lista);
			when(this.vendaRepository.save(venda)).thenReturn(venda);
			when(this.vendaRepository.findById(1L)).thenReturn(Optional.of(venda));
			//when(this.vendaRepository.buscarVendasAcimaValor(5));
			
			
		}
		
		@Test
		@DisplayName("FINDALL")
		void cenario1() {
			
			
			ResponseEntity<List<Venda>> response = this.vendaController.listAll();
			List<Venda> lista = response.getBody();
			
			assertEquals(2, lista.size());
			
		}
		
		@Test
		@DisplayName("FINDALL")
		void cenario3() {
			
			
			ResponseEntity<List<Venda>> response = this.vendaController.listAll();
			List<Venda> lista = response.getBody();
			
			assertNotEquals(0, lista.size());
			
		}

		@Test
		@DisplayName("TESTE DE INTEGRAÇÃO MOCANDO O REPOSITORY PARA O MÉTODO SAVE")
		void cenario2() {
			Venda venda = new Venda(3, "venda1", 3.55, 2.44, "OK", null, null, null);

			
			ResponseEntity <String> response = this.vendaController.save(venda);
			//String mensagem = response.getBody();
			
			assertEquals(HttpStatus.CREATED, response.getStatusCode());
		}
		

		@Test
		@DisplayName("TESTE DE INTEGRAÇÃO MOCANDO O REPOSITORY PARA O MÉTODO SAVE")
		void cenarioB() {
			Venda venda = new Venda(3, "venda1", 3.55, 2.44, "OK", null, null, null);

			
			ResponseEntity <String> response = this.vendaController.save(venda);
			String mensagem = response.getBody();
			
			assertEquals("Venda salva com sucesso", mensagem);
		}

		@Test
		@DisplayName("TESTE DE INTEGRAÇÃO MOCANDO O REPOSITORY PARA O MÉTODO SAVE")
		void cenarioC() {
			Venda venda = null;

			
			ResponseEntity <String> response = this.vendaController.save(venda);
			//String mensagem = response.getBody();
			
			assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
			
		}
		
		@Test
		@DisplayName("FindById")
		void cenarioD() {
			
			
			
			ResponseEntity <Venda> response = this.vendaController.findById(1L);
			Venda venda = response.getBody();
			
			assertEquals("venda1", venda.getEnderecoVenda());
		}
		
		
		@Test
		@DisplayName("FindById")
		void cenarioF() {
			
			
			
			ResponseEntity <Venda> response = this.vendaController.findById(-1L);
			//Venda venda = response.getBody();
			
			assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		}
		
		
		@Test
		@DisplayName("Delete")
		void cenarioG() {
			
			
			
			ResponseEntity <String> response = this.vendaController.delete(1L);
			String mensagem = response.getBody();
			
			assertEquals(" Venda deletada com sucesso", mensagem);
		}
		
		@Test
		@DisplayName("buscar valor")
		void cenarioI() {
			
		//	Venda venda = new Venda(3, "venda1", 3.55, 2.44, "OK", null, null, null);
		
			ResponseEntity <List<Venda>> response = this.vendaController.buscarVendasAcimaValor(5);
			
			assertEquals(HttpStatus.OK, response.getStatusCode());
		}
	
		
		
	
}
