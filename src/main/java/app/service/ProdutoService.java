package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Produto;
import app.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public String save(Produto produto) {
		this.produtoRepository.save(produto);
		return produto.getNomeProduto()+ " Produto salvo com sucesso";
	}
	
	public String update(long idProduto, Produto produto) {
		produto.setIdProduto(idProduto);
		this.produtoRepository.save(produto);
		return produto.getNomeProduto()+ " Produto alterado com sucesso";
	}
	
	public List<Produto> listAll(){
		return this.produtoRepository.findAll();
	}
	
	public Produto findById(long idProduto) {
		Produto produto = this.produtoRepository.findById(idProduto).get();
		return produto;
	}
	
	public String delete(long idProduto) {
		this.produtoRepository.deleteById(idProduto);
		return " Produto deletado com sucesso";
	}
	
	//consulta BD
	public List<Produto> findByProduto(long idProduto){
		Produto produto = new Produto();
		produto.setIdProduto(idProduto);
		return this.produtoRepository.findByProduto(produto);
	}
	
	public List<Produto> findByNome(String nomeProduto){
		return this.produtoRepository.findByNome(nomeProduto);
	}
	
	public List<Produto> findByFirstnameStartingWith(String nomeProduto){
		return this.produtoRepository.findByFirstnameStartingWith(nomeProduto);
	}
	
	public List<Produto> buscarProdutosAcimaValor(double valorProduto){
		return this.produtoRepository.buscarProdutosAcimaValor(valorProduto);
	}
}
