package br.com.tinnova.veiculo.veiculo.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class VeiculoResponse {
	private UUID idVeiculo;
}
