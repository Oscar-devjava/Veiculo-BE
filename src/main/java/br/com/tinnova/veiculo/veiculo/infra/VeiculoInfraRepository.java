package br.com.tinnova.veiculo.veiculo.infra;

import org.springframework.stereotype.Repository;

import br.com.tinnova.veiculo.veiculo.application.repository.VeiculoRepository;
import br.com.tinnova.veiculo.veiculo.domain.Veiculo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Repository
@Log4j2
@RequiredArgsConstructor
public class VeiculoInfraRepository implements VeiculoRepository {
	
	private final VeiculoSpringDataJPARepository veiculoSpringDataJPARepository;

	@Override
	public Veiculo salva(Veiculo veiculo) {
		log.info("[inicia] VeiculoInfraRepository - salva ");
		var veiculoCadastrado = veiculoSpringDataJPARepository.save(veiculo);
		log.info("[finaliza] VeiculoInfraRepository - salva ");
		return veiculoCadastrado;
	}

}
