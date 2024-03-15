package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//anotação usada para gerar automaticamente um construtor sem argumentos para uma classe
@NoArgsConstructor
//anotação é usada para gerar automaticamente um construtor que aceita todos os campos da classe como argumentos
@AllArgsConstructor
@Entity
public class Venda {
	
	/* 
	anotacao que define idVenda como um id no DB e a generated value para definir o mesmo como 
	auto increment
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVenda;
	private String enderecoVenda;
	private double valorVenda;
	
	//Relacao de muitas vendas para um funcionario 
	@ManyToOne (cascade = CascadeType.ALL)
	@JsonIgnoreProperties("venda")
	private Funcionario funcionario;
	
	//Relacao de muitas vendas para um cliente 
	@ManyToOne (cascade = CascadeType.ALL)
	@JsonIgnoreProperties("venda")
	private Cliente cliente;
	
	//relacao de muitos para muitos de vendas para produtos
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable (name =  "venda_produto")
	private List<Produto> produto;
	
	
}
