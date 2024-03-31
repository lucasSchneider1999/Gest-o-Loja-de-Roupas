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

import app.entity.Produto;
import app.service.ProdutoService;


@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Produto produto) {
		
		try {
			String mensagem = this.produtoService.save(produto);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{idProduto}")
	public ResponseEntity<String> update(@RequestBody Produto produto, @PathVariable long idProduto) {
		
		try {
			String mensagem = this.produtoService.update(idProduto, produto);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Produto>> listAll() {
		
		try {
			List<Produto> lista = this.produtoService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{idProduto}")
	public ResponseEntity<Produto> findById(@PathVariable long idProduto) {
		
		try {
			Produto produto = this.produtoService.findById(idProduto);
			return new ResponseEntity<>(produto, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{idProduto}")
	public ResponseEntity<String> delete(@PathVariable long idProduto) {
		
		try {
			String mensagem = this.produtoService.delete(idProduto);
			return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	//consultas BD
	
	@GetMapping("/findByNome")
	public ResponseEntity<List<Produto>> findByNome (@RequestParam String nomeProduto){
		
		try {
			List<Produto> lista = this.produtoService.findByNome(nomeProduto);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
			
	}
	
	@GetMapping("/findByPrimeiroNome")
	public ResponseEntity<List<Produto>> findByPrimeiroNome(@RequestParam String nomeProduto){
		
		try {
			List<Produto> lista = this.produtoService.findByPrimeiroNome(nomeProduto);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
			
	}
	
	@GetMapping("/buscarProdutosAcimaValor")
	public ResponseEntity<List<Produto>> buscarProdutosAcimaValor(@RequestParam double valorProduto) {

		try {
			List<Produto> lista = this.produtoService.buscarProdutosAcimaValor(valorProduto);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
