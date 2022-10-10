package br.com.tinnova.veiculo.veiculo.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import br.com.tinnova.veiculo.veiculo.domain.Tamanho;
import br.com.tinnova.veiculo.veiculo.domain.Tipo;
import lombok.Value;

@Value
public class VeiculoRequest {
	@NotEmpty(message = "O campo marca do veículo não pode estar vazio")
	private String marca;
	@NotEmpty(message = "O campo marca do veículo não pode estar vazio")
	private String cor;
	@NotEmpty(message = "O campo marca do veículo não pode estar vazio")
	private Tipo tipo;
	@NotEmpty(message = "O campo marca do veículo não pode estar vazio")
	private Tamanho tamanho;
	private LocalDate anoFabricacao;
	
}
