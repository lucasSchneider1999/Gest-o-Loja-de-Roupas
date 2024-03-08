package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Produto {
	
	@Id
	long idProduto;
	String nomeProduto;
	double valorProduto;
	
}
