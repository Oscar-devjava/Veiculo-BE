package br.com.tinnova.veiculo.veiculo.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.tinnova.veiculo.veiculo.application.api.VeiculoDetalhadoResponse;
import br.com.tinnova.veiculo.veiculo.application.api.VeiculoRequest;
import br.com.tinnova.veiculo.veiculo.application.api.VeiculoResponse;
import br.com.tinnova.veiculo.veiculo.application.api.VeiculosListResponse;
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

	@Override
	public List<VeiculosListResponse> visualizaTodosVeiculos() {
		log.info("[inicia] VeiculoApplicationService - cadastraVeiculo");
		List<Veiculo> lista = veiculoRepository.buscaTodosVeiculos();
		log.info("[finaliza] VeiculoApplicationService - cadastraVeiculo");		
		return VeiculosListResponse.converte(lista);
	}

	@Override
	public VeiculoDetalhadoResponse buscaVeiculoPorId(UUID idVeiculo) {
		log.info("[inicia] VeiculoApplicationService - cadastraVeiculo");
		Veiculo veiculo = veiculoRepository.buscaVeiculoPorId(idVeiculo);
		log.info("[finaliza] VeiculoApplicationService - cadastraVeiculo");		
		return new VeiculoDetalhadoResponse(veiculo);
	}

	@Override
	public void deletaVeiculoPorId(UUID idVeiculo) {
		log.info("[inicia] VeiculoApplicationService - deletaVeiculoPorId");
		veiculoRepository.buscaVeiculoPorId(idVeiculo);
		veiculoRepository.deleta(idVeiculo);
		log.info("[inicia] VeiculoApplicationService - deletaVeiculoPorId");
	}
}
