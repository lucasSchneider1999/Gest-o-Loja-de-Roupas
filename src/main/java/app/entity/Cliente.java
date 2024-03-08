package app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idCliente;
	String nome;
	String cpf;
	int idade;
	String telefone;
	
	@OneToMany(mappedBy = "cliente")
	private List<Venda> venda;
}
