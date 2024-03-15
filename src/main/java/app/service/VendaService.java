package app.service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Funcionario;
import app.entity.Produto;
import app.entity.Venda;
import app.repository.VendaRepository;

@Service
public class VendaService {
	
	//uma anotacao para gerar uma instancia de um objeto de maneira automatica
	@Autowired
	private VendaRepository vendaRepository;
	
	//metodos CRUD
	
	public String save(Venda venda) {
		//this.vendaRepository.save(venda);
		List <Produto> produtos = venda.getProduto();
		//classe para limitar as casas decimais do valor final da venda
		DecimalFormat df = new DecimalFormat("#.##");
		double valorVenda = 0;
		for (Produto produto : produtos) {
			valorVenda += produto.getValorProduto();
		}
		//string para receber o valor final ja formatado 
		String valorFormatado = df.format(valorVenda);
		venda.setValorVenda(valorVenda);
		this.vendaRepository.save(venda);
		return valorFormatado +" Pedido realizado com sucesso";

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
	
	//Consultas DB
	
	public List<Venda> findByFuncionario(long idFuncionario){
        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(idFuncionario);
        return this.vendaRepository.findByFuncionario(funcionario);
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

}
