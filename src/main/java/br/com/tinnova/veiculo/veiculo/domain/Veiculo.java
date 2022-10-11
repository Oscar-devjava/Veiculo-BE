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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.tinnova.veiculo.veiculo.application.api.AlteraDetalhesRequest;
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
	@NotNull
	private Marca marca;
	@NotBlank
	private String cor;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Tipo tipo;
	@Enumerated(EnumType.STRING)
	private Tamanho tamanho;
	@NotNull
	private LocalDate anoFabricacao;
	private Boolean vendido;
	private String descricao;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraUltimaAlteracao;
	
	public Veiculo( VeiculoRequest veiculoRequest) {
		this.marca = veiculoRequest.getMarca();
		this.cor = veiculoRequest.getCor();
		this.tipo = veiculoRequest.getTipo();
		this.tamanho = veiculoRequest.getTamanho();
		this.anoFabricacao = veiculoRequest.getAnoFabricacao();
		this.vendido = veiculoRequest.getVendido();
		this.descricao = veiculoRequest.getDescricao();
		this.dataHoraDoCadastro = LocalDateTime.now();
		
	}

	public void altera(AlteraDetalhesRequest alteraDetalhesRequest) {
		this.cor = alteraDetalhesRequest.getCor();	
		this.vendido = alteraDetalhesRequest.getVendido();
		this.descricao = alteraDetalhesRequest.getDescricao();
		this.dataHoraUltimaAlteracao = LocalDateTime.now();
	}
}
