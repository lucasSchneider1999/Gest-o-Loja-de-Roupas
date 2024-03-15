package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Funcionario;
import app.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	
	public List<Venda> findByFuncionario(Funcionario funcionario);
	
	public List<Venda> findByFuncionarioMatricula(String matricula);
		
	public List<Venda> findByClienteNome(String nome);
	
	@Query("FROM Venda v WHERE v.valorVenda > :valorVenda")
	public List<Venda> buscarVendasAcimaValor(double valorVenda);
	
}
