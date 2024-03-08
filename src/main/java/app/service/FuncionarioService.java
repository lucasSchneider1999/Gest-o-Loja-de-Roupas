package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Funcionario;
import app.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	@Autowired
	FuncionarioRepository funcionarioRepository;
	

	
	public String save (Funcionario funcionario) {
		this.funcionarioRepository.save(funcionario);
		return funcionario.getNome() + " Foi registrado";
	}
	
	public List <Funcionario> listAll () {
	return this.funcionarioRepository.findAll();
		
	}
	

	
	public Funcionario findById(long idFuncionario) {

		Funcionario funcionario = this.funcionarioRepository.findById(idFuncionario).get();
		return funcionario;

	}
	
	public String update (Funcionario funcionario, long idFuncionario) {
		funcionario.setIdFuncionario(idFuncionario);
		this.funcionarioRepository.save(funcionario);
		return "O " + funcionario.getNome() + " Foi atualizado";
		
	}
	
	public String delete (long idFuncionario) {
		this.funcionarioRepository.deleteById(idFuncionario);
		return "Funcionario deletado";
	}
	
	
}
