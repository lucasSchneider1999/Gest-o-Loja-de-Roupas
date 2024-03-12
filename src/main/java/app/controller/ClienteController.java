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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Cliente;
import app.service.ClienteService;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Cliente cliente){

		try {
			String mensagem = this.clienteService.save(cliente);
			return new ResponseEntity<>(mensagem,HttpStatus.OK);		
		} catch (Exception e) {

			return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);		

		}

	}

	@GetMapping("/listAll")
	public ResponseEntity <List<Cliente>> listAll(){

		try {
			List<Cliente> lista = this.clienteService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.CREATED);
		} catch (Exception e) {			
			return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);		

		}

	}

	@GetMapping("/findById/{idCliente}")
	public ResponseEntity <Cliente> findById(@PathVariable long idCliente){

		try {
			Cliente cliente = this.clienteService.findById(idCliente);
			return new ResponseEntity<>(cliente, HttpStatus.CREATED);
		} catch (Exception e) {			
			return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);		

		}

	}
	
	@PutMapping("/update/{idCliente}")
	public ResponseEntity<String> update(@RequestBody Cliente cliente, @PathVariable long idCliente){

		try {
			String mensagem = this.clienteService.update(cliente, idCliente);
			return new ResponseEntity<>(mensagem,HttpStatus.OK);		
		} catch (Exception e) {

			return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);		

		}

	}
	
	@DeleteMapping("/delete/{idCliente}")
	public ResponseEntity<String> update(@PathVariable long idCliente){

		try {
			String mensagem = this.clienteService.delete(idCliente);
			return new ResponseEntity<>(mensagem,HttpStatus.OK);		
		} catch (Exception e) {

			return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);		

		}

	}
	
	//consultas DB
	@GetMapping("/findByNome")
	public ResponseEntity<List<Cliente>> findByNome (@RequestParam String nome){
		
		try {
			List<Cliente> lista = this.clienteService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
			
	}
	
	@GetMapping("/findByCpf")
	public ResponseEntity<List<Cliente>> findByCpf (@RequestParam String cpf){
		
		try {
			List<Cliente> lista = this.clienteService.findByCpf(cpf);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
			
	}
	
	@GetMapping("/findByNomeStartingWith")
	public ResponseEntity<List<Cliente>> findByNomeStartingWith (@RequestParam String nome){
		
		try {
			List<Cliente> lista = this.clienteService.findByNomeStartingWith(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
			
	}
	
	@GetMapping("/buscarClienteIdade")
	public ResponseEntity<List<Cliente>> buscarClienteIdade (@RequestParam int idade){
		
		try {
			List<Cliente> lista = this.clienteService.buscarClienteIdade(idade);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
			
	}

}
