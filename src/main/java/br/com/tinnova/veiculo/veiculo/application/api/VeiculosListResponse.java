package br.com.tinnova.veiculo.veiculo.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.tinnova.veiculo.veiculo.domain.Marca;
import br.com.tinnova.veiculo.veiculo.domain.Veiculo;
import lombok.Getter;
@Getter
public class VeiculosListResponse {
	private UUID idVeiculo;
	private Marca marca;
	private Boolean vendido;
	private String descricao;
	
	public static List<VeiculosListResponse> converte(List<Veiculo> lista) {
		return lista.stream().map(VeiculosListResponse :: new).collect(Collectors.toList());
	}

	public VeiculosListResponse(Veiculo veiculo) {
		super();
		this.idVeiculo = veiculo.getIdVeiculo();
		this.marca = veiculo.getMarca();
		this.vendido = veiculo.getVendido();
		this.descricao = veiculo.getDescricao();
	}
	
	

}
