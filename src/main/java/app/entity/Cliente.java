package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	private long idCliente;
	@NotBlank(message = "Nome do cliente nao pode estar vazio")
	private String nome;
	@NotBlank(message = "Cpf nao pode estar vazio")
	private String cpf;
	@NotNull(message = "Idade do cliente nao pode ser nulo")
	private int idade;
	@NotBlank(message = "Telefone nao pode estar vazio")
	private String telefone;
	
	//relacao de um cliente para muitas vendas
	@OneToMany(mappedBy = "cliente")
	@JsonIgnoreProperties("cliente")
	private List<Venda> venda;
}
