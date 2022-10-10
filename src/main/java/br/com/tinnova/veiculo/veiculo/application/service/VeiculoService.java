package br.com.tinnova.veiculo.veiculo.application.service;

import java.util.List;

import javax.validation.Valid;

import br.com.tinnova.veiculo.veiculo.application.api.VeiculoRequest;
import br.com.tinnova.veiculo.veiculo.application.api.VeiculoResponse;
import br.com.tinnova.veiculo.veiculo.application.api.VeiculosListResponse;

public interface VeiculoService {

	VeiculoResponse cadastraVeiulo(@Valid VeiculoRequest veiculoRequest);

	List<VeiculosListResponse> visualizaTodosVeiculos();

}
