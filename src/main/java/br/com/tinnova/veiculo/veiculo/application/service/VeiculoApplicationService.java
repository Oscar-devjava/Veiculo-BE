package br.com.tinnova.veiculo.veiculo.application.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.tinnova.veiculo.veiculo.application.api.VeiculoRequest;
import br.com.tinnova.veiculo.veiculo.application.api.VeiculoResponse;
import br.com.tinnova.veiculo.veiculo.application.repository.VeiculoRepository;
import br.com.tinnova.veiculo.veiculo.domain.Veiculo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class VeiculoApplicationService implements VeiculoService {
	
	private final VeiculoRepository veiculoRepository;

	@Override
	public VeiculoResponse cadastraVeiulo(@Valid VeiculoRequest veiculoRequest) {
		log.info("[inicia] VeiculoApplicationService - cadastraVeiculo");
		Veiculo veiculo = veiculoRepository.salva(new Veiculo(veiculoRequest));
		log.info("[finaliza] VeiculoApplicationService - cadastraVeiculo");
		return VeiculoResponse.builder().idVeiculo(veiculo.getIdVeiculo()).build();
	}

}
