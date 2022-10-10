package br.com.tinnova.veiculo.veiculo.application.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.tinnova.veiculo.veiculo.application.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class VeiculoRestController implements VeiculoAPI {
	
	private final VeiculoService veiculoService;

	@Override
	public VeiculoResponse postCadastraNovoVeiculo(@Valid VeiculoRequest veiculoRequest) {
		log.info("[inicia] VeiculoRestController - postCadastraNovoVeiculo");
		VeiculoResponse veiculo = veiculoService.cadastraVeiulo(veiculoRequest);
		log.info("[finaliza] VeiculoRestController - postCadastraNovoVeiculo");
		return veiculo;
	}

	@Override
	public List<VeiculosListResponse> getVisualizaTodosVeiculos() {
		log.info("[inicia] VeiculoRestController - getVisualizaTodosVeiculos");
		List<VeiculosListResponse> veiculos = veiculoService.visualizaTodosVeiculos();
		log.info("[finaliza] VeiculoRestController - getVisualizaTodosVeiculos");
		return veiculos;
	}

}
