package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Venda {

	@Id
	private long idVenda;
	private String enderecoVenda;
	private int valorVenda;
	
}
