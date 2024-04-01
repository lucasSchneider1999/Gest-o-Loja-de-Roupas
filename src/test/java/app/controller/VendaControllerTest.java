package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
			
			when(this.vendaRepository.findAll()).thenReturn(lista);
			
		}
		
		@Test
		@DisplayName("TESTE DE INTEGRAÇÃO MOCANDO O REPOSITORY PARA O MÉTODO FINDALL")
		void cenario1() {
			
			ResponseEntity<List<Venda>> response = this.vendaController.listAll();
			List<Venda> lista = response.getBody();
			
			assertEquals(2, lista.size());
			
		}
}
