package br.com.tinnova.veiculo.veiculo.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.tinnova.veiculo.veiculo.domain.Marca;
import br.com.tinnova.veiculo.veiculo.domain.Tamanho;
import br.com.tinnova.veiculo.veiculo.domain.Tipo;
import lombok.Value;

@Value
public class VeiculoRequest {
	@NotNull(message = "As marcas diponiveis são; Hyundai,Fiat,Renault,Volkswagen, "
			+ "Mercedes_Benz,Land_Rover,"
			+ " Chevrolet,Ford eToyota")
	private Marca marca;
	@NotEmpty(message = "O campo cor do veículo não pode estar vazio")
	private String cor;	
	@NotNull(message = "O campo tipo do veículo não pode estar vazio")
	private Tipo tipo;
	@NotNull(message = "O campo tamanho do veículo não pode estar vazio")
	private Tamanho tamanho;
	private LocalDate anoFabricacao;
	private Boolean vendido;
	private String descricao;
	
}
