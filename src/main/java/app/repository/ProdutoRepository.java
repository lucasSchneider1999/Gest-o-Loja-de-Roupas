package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findByNomeProduto(String nomeProduto);
	
	public List<Produto> findByNomeProdutoStartingWith(String nomeProduto);
	
	@Query("FROM Produto p WHERE p.valorProduto > :valorProduto")
	public List<Produto> buscarProdutosAcimaValor(double valorProduto);

}
