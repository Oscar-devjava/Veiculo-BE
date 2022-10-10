package br.com.tinnova.veiculo.veiculo.application.service;

import javax.validation.Valid;

import br.com.tinnova.veiculo.veiculo.application.api.VeiculoRequest;
import br.com.tinnova.veiculo.veiculo.application.api.VeiculoResponse;

public interface VeiculoService {

	VeiculoResponse cadastraVeiulo(@Valid VeiculoRequest veiculoRequest);

}
