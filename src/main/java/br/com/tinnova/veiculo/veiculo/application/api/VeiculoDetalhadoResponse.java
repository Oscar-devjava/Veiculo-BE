package br.com.tinnova.veiculo.veiculo.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.tinnova.veiculo.veiculo.domain.Tamanho;
import br.com.tinnova.veiculo.veiculo.domain.Tipo;
import br.com.tinnova.veiculo.veiculo.domain.Veiculo;
import lombok.Getter;
@Getter
public class VeiculoDetalhadoResponse {
	private String marca;
	private String chassi;
	private String placa;
	private String cor;
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	@Enumerated(EnumType.STRING)
	private Tamanho tamanho;
	private LocalDate anoFabricacao;
	private LocalDateTime dataHoraDoCadastro;
	
	public VeiculoDetalhadoResponse(Veiculo veiculo) {
		this.marca = veiculo.getMarca();
		this.chassi = veiculo.getChassi();
		this.placa = veiculo.getPlaca();
		this.cor = veiculo.getCor();
		this.tipo =veiculo.getTipo();
		this.tamanho = veiculo.getTamanho();
		this.anoFabricacao = veiculo.getAnoFabricacao();
		this.dataHoraDoCadastro = veiculo.getDataHoraDoCadastro();
	}
	
}
