package br.com.tinnova.veiculo.veiculo.application.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/v1/veiculo")
public interface VeiculoAPI {
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	VeiculoResponse postCadastraNovoVeiculo(@Valid @RequestBody VeiculoRequest veiculoRequest );
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	List<VeiculosListResponse> getVisualizaTodosVeiculos();
}
