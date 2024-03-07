package app.service;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class VendaService {
	
	private long idVenda;
	private String enderecoVenda;
	private int valorVenda;
	
}
