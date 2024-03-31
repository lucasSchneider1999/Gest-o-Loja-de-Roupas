package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
<<<<<<< HEAD
=======
import jakarta.validation.constraints.NotNull;
>>>>>>> 3178e00e32d186a553d11b7b8faeaf1a86710221
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduto;
<<<<<<< HEAD
	@NotBlank
=======
	@NotBlank(message = "Nome do produto nao pode estar vazio")
>>>>>>> 3178e00e32d186a553d11b7b8faeaf1a86710221
	private String nomeProduto;
	@NotNull(message = "Valor do produto nao pode estar vazio")
	private double valorProduto;
	
}
