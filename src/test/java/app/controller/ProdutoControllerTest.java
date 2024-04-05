package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

import app.entity.Produto;
import app.repository.ProdutoRepository;

@SpringBootTest
public class ProdutoControllerTest {
	@Autowired
	ProdutoController produtoController;
	
	@MockBean
	ProdutoRepository produtoRepository;
	
	@BeforeEach
	void setup(){
		
		List<Produto> list = new ArrayList<>();
		list.add(new Produto(1, "bermuda", 1200.99));
		list.add(new Produto(2, "chapeu", 899.99));
		Produto produto = new Produto(3, "camisa", 450.75);
		
		when(this.produtoRepository.save(produto)).thenReturn(produto);
		when(this.produtoRepository.findAll()).thenReturn(list);
		when(this.produtoRepository.findById(3L)).thenReturn(Optional.of(produto));
		//when(this.produtoRepository.findByNomeProduto("chapeu")).thenReturn(list.get(1));
	}
	
	@Test
	@DisplayName("FINDALL PRODUTO")
	void cenario1() {
		
		ResponseEntity<List<Produto>> response = this.produtoController.listAll();
		List<Produto> list = response.getBody();
		
		assertEquals(2, list.size());
		
	}
	
//	@Test
//	@DisplayName("TESTE FINDALL EXCEPTION")
//    void cenario6() {
//        // Configurando o mock para lançar a exceção quando o método listAll() do productDao for chamado
//		List<Produto> listE = new ArrayList<>();
//		listE.add(new Produto(1, "Placa de video", 1200.99));
//		listE.add(null);
//		
//		ResponseEntity<List<Produto>> response = this.produtoController.listAll();
//
//        // Testando se a exceção é lançada corretamente
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//    }
	
	@Test
	@DisplayName("SAVE MOCK")
	void cenario2() {
		Produto produto = new Produto(4, "calca", 250.75);
		
		ResponseEntity<String> response = this.produtoController.save(produto);
		String mensagem = response.getBody();
		
		assertEquals(produto, produto);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals("calca Produto salvo com sucesso", mensagem);
	}
	
	@Test
	@DisplayName("SAVE MOCK EXCEPTION")
	void cenario3() {
		
		Produto produto = null;
		ResponseEntity<String> response = this.produtoController.save(produto);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}
	
	@Test
	@DisplayName("FINDBYID MOCK")
	void cenario4() {
		
		ResponseEntity<Produto> response = this.produtoController.findById(3L);
		Produto produto = response.getBody();
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals("camisa", produto.getNomeProduto());
		
	}
	
	@Test
	@DisplayName("FINDBYID MOCK EXCEPTION")
	void cenario5() {
		
		ResponseEntity<Produto> response = this.produtoController.findById(9L);
		
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		
	}
	
	@Test
	@DisplayName("FINDBYPRIMEIRONOME")
	void cenario6() {
		
		List<Produto> list = new ArrayList<>();
		list.add(new Produto(1, "bermuda", 1200.99));
		list.add(new Produto(2, "chapeu", 899.99));
		
		ResponseEntity<List<Produto>> response = this.produtoController.findByPrimeiroNome("chapeu");
		//List<Produto> produto = response.getBody();
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		//assertEquals(2L, list.get(1).getIdProduto());
		//assertEquals(list.get(1), response.getBody());
		
	}
	
	@Test
	@DisplayName("FINDBYPRODUTOSACIMAVALOR")
	void cenario7() {
		
		List<Produto> list = new ArrayList<>();
		list.add(new Produto(1, "bermuda", 1200.99));
		list.add(new Produto(2, "chapeu", 899.99));
		
		ResponseEntity<List<Produto>> response = this.produtoController.buscarProdutosAcimaValor(1000);
		//List<Produto> produtos = response.getBody();
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		//assertEquals(1, produtos.get(0).getIdProduto());
		//assertEquals(list.get(1), response.getBody());
		
	}
	
	
}
