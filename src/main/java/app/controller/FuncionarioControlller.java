package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Funcionario;
import app.service.FuncionarioService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioControlller {
	@Autowired
	public FuncionarioService funcionarioService;
	

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Funcionario funcionario){

		try {
			String mensagem = this.funcionarioService.save(funcionario);
			return new ResponseEntity<>(mensagem,HttpStatus.OK);		
		} catch (Exception e) {

			return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);		

		}

	}

	@GetMapping("/listAll")
	public ResponseEntity <List<Funcionario>> listAll(){

		try {
			List<Funcionario> lista = this.funcionarioService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.CREATED);
		} catch (Exception e) {			
			return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);		

		}

	}

	@GetMapping("/findById/{idFuncionario}")
	public ResponseEntity <Funcionario> findById(@PathVariable long idFuncionario){

		try { 
			Funcionario funcionario = this.funcionarioService.findById(idFuncionario);
			return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
		} catch (Exception e) {			
			return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);		

		}

	}
	
	@PutMapping("/update/{idFuncionario}")
	public ResponseEntity<String> update(@RequestBody Funcionario funcionario, @PathVariable long idFuncionario){

		try {
			String mensagem = this.funcionarioService.update(funcionario, idFuncionario);
			return new ResponseEntity<>(mensagem,HttpStatus.OK);		
		} catch (Exception e) {

			return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);		

		}

	}
	
	@DeleteMapping("/delete/{idFuncionario}")
	public ResponseEntity<String> update(@PathVariable long idFuncionario){

		try {
			String mensagem = this.funcionarioService.delete(idFuncionario);
			return new ResponseEntity<>(mensagem,HttpStatus.OK);		
		} catch (Exception e) {

			return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);		

		}

	}
	
	//consulta DB
	
	@GetMapping("/findByMatricula")
	public ResponseEntity<List<Funcionario>> findByMatricula(@RequestParam String matricula) {
		
		try {
			
			List<Funcionario> lista = this.funcionarioService.findByMatricula(matricula);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@GetMapping("/findByNome")
	public ResponseEntity<List<Funcionario>> findByNome(@RequestParam String nome) {
		try {
			List<Funcionario> lista = this.funcionarioService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByIdFuncionario")
	public ResponseEntity<List<Funcionario>> findByIdFuncionario(@RequestParam long idFuncionario){
		
		try {
			List<Funcionario> lista = this.funcionarioService.findByIdFuncionario(idFuncionario);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/buscarIdadeAcima")
	public ResponseEntity<List<Funcionario>> buscarIdadeAcima(@RequestParam int idade) {

		try {
			
			List<Funcionario> lista = this.funcionarioService.buscarIdadeAcima(idade);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	
}
