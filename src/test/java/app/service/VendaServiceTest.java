package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.entity.Produto;
import app.entity.Venda;

@SpringBootTest
public class VendaServiceTest {

	@Autowired
	VendaService vendaService;

	@Test
	@DisplayName("Teste Unitario Metodo ValorTotal")
	void cenario1 () {

		List<Produto> produtos = new ArrayList<>();

		produtos.add(new Produto(1, "Camiseta", 10));
		produtos.add(new Produto(2, "Calca", 15));
		produtos.add(new Produto(3, "Calcado", 10));


		double valorFinal = this.vendaService.valorFinal(produtos);
		

		assertEquals(35, valorFinal);
	}

	@Test
	@DisplayName("Teste Unitario Metodo ValorTotal com exception")
	void cenario2 () {

		List<Produto> produtos = new ArrayList<>();

		produtos.add(new Produto(1, null, 10));
		produtos.add(new Produto(2, "Calca", 15));
		produtos.add(new Produto(3, "Calcado", 10));



		assertThrows(Exception.class, () -> {
			double valorFinal = this.vendaService.valorFinal(produtos);
		});
	}

	@Test
	@DisplayName("Teste Unitario Metodo verificarStatus")
	void cenarioStatus1 () {

		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto(2, "Calca", 15));
		produtos.add(new Produto(3, "Calcado", 10));

		Venda venda = new Venda();
		venda.setStatus("Cancelado"); 
		Venda verificarStatusFinal = vendaService.verificarStatus(venda);

		assertEquals(0, verificarStatusFinal.getValorFinal());
		assertEquals(null, verificarStatusFinal.getProduto());


	}
	
	
    }
	
	



