package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.entity.Funcionario;

@SpringBootTest

public class FuncionarioServiceTest {

	@Autowired
	FuncionarioService funcionarioService;
	
	@Test 
	@DisplayName("UPDATE")
	void cenario7(){
		Funcionario funcionario = new Funcionario (1, "Jose Ricardo", 35, "2444", null);
		String response = this.funcionarioService.update(funcionario, 1);
		
		
		assertEquals("O Jose Ricardo Foi atualizado", response);
	}
	
}
