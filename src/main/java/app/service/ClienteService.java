package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Cliente;
import app.repository.ClienteRepository;
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public String save (Cliente cliente) {
		this.clienteRepository.save(cliente);
		return cliente.getNome() + " Foi registrado";
	}
	
	public List <Cliente> listAll () {
	return this.clienteRepository.findAll();
		
	}
	

	
	public Cliente findById(long idCliente) {

		Cliente cliente = this.clienteRepository.findById(idCliente).get();
		return cliente;

	}
	
	public String update (Cliente cliente, long idCliente) {
		cliente.setIdCliente(idCliente);
		this.clienteRepository.save(cliente);
		return "O " + cliente.getNome() + " Foi atualizado";
		
	}
	
	public String delete (long idAutor) {
		this.clienteRepository.deleteById(idAutor);
		return "Cliente deletado";
	}
	
}
