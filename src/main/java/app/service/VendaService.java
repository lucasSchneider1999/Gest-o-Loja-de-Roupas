package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Funcionario;
import app.entity.Venda;
import app.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public String save(Venda venda) {
		this.vendaRepository.save(venda);
		return venda.getValorVenda() +" Pedido realizado com sucesso";
	}
	
	public String update(long idVenda, Venda venda) {
		venda.setIdVenda(idVenda);
		this.vendaRepository.save(venda);
		return " Venda Alterada com sucesso";
	}
	
	public List<Venda> listAll() {
		return this.vendaRepository.findAll();
	}
	
	public Venda findById(long idVenda) {
		Venda venda = this.vendaRepository.findById(idVenda).get();
		return venda;
	}
	
	public String delete(long idVenda) {
		this.vendaRepository.deleteById(idVenda);
		return " Venda deletada com sucesso";
	}
	
	public List<Venda> buscarVendasAcimaValor(double valorVenda){
		return this.vendaRepository.buscarVendasAcimaValor(valorVenda);
	}
	
	public List<Venda> findByFuncionarioMatricula(String matricula){
		return this.vendaRepository.findByFuncionarioMatricula(matricula);
	}
	
	public List<Venda> findByClienteNome(String nome){
		return this.vendaRepository.findByClienteNome(nome);
	}

	
	public List<Venda> findByFuncionario(long idFuncionario){
		Funcionario funcionario = new Funcionario();
		funcionario.setIdFuncionario(idFuncionario);
		return this.vendaRepository.findByFuncionario(funcionario);
	}
}
