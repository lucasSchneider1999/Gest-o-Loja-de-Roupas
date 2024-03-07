package app.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Venda {

	private long idVenda;
	private String enderecoVenda;
	private int valorVenda;
	
}
