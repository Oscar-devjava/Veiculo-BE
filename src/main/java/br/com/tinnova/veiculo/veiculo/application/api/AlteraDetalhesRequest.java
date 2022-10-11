package br.com.tinnova.veiculo.veiculo.application.api;

import lombok.Getter;

@Getter
public class AlteraDetalhesRequest {
	private String cor;	
	private Boolean vendido;
	private String descricao;
}
