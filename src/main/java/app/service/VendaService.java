package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Funcionario;
import app.entity.Produto;
import app.entity.Venda;
import app.repository.VendaRepository;
import jakarta.validation.Valid;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	private Venda venda;
	
	
	//metodo de soma valorFinal
	public double valorFinal (@Valid List <Produto> produtos) {
		
		
		double valorFinal = 0;
		for (@Valid Produto produto : produtos) {
			produto.setNomeProduto(produto.getNomeProduto().toUpperCase());
			valorFinal += produto.getValorProduto();
		}
		return valorFinal;
	}


	//comentando pra nao se perder
	public String save(Venda venda) {
		double valorFinal = this.valorFinal(venda.getProduto());
		venda.setValorFinal(valorFinal);
		this.vendaRepository.save(venda);
		return "Venda salva com sucesso";
		
	}

	public String update(long idVenda, Venda venda) {
		venda.setIdVenda(idVenda);
		//Regra de negocio...
		double valorFinal = this.valorFinal(venda.getProduto());
		venda.setValorFinal(valorFinal);
		//Regra de negocio
		venda = this.verificarStatus(venda);
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

	//Consultas BD
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
	
	public Venda verificarStatus (Venda venda) {
		if (venda.getStatus().equals("Cancelado")) {
			venda.setValorFinal(0);
			venda.setProduto(null);
		}
		
		return venda;
		
	}
	

}
