package br.com.tinnova.veiculo.veiculo.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.tinnova.veiculo.veiculo.application.api.VeiculoRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "UUID", name = "idVeiculo", unique = true, nullable = false, updatable = false)
	private UUID idVeiculo;
	@NotBlank
	private String marca;
	@NotBlank
	private String chassi;
	@NotBlank
	private String placa;
	@NotBlank
	private String cor;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Tipo tipo;
	@Enumerated(EnumType.STRING)
	private Tamanho tamanho;
	@NotNull
	private LocalDate anoFabricacao;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDate dataHoraUltimaAlteracao;
	
	public Veiculo(@Valid VeiculoRequest veiculoRequest) {
		this.marca = veiculoRequest.getMarca();
		this.chassi = veiculoRequest.getChassi();
		this.placa = veiculoRequest.getPlaca();
		this.cor = veiculoRequest.getCor();
		this.tipo = veiculoRequest.getTipo();
		this.tamanho = veiculoRequest.getTamanho();
		this.anoFabricacao = veiculoRequest.getAnoFabricacao();
		this.dataHoraDoCadastro = LocalDateTime.now();
		
	}
}
