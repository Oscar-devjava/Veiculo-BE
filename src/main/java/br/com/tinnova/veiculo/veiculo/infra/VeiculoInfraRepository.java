package br.com.tinnova.veiculo.veiculo.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.tinnova.veiculo.veiculo.application.repository.VeiculoRepository;
import br.com.tinnova.veiculo.veiculo.domain.Veiculo;
import br.com.tinnova.veiculo.veiculo.handler.APIException;
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
		try {
			veiculoSpringDataJPARepository.save(veiculo);
		} catch (DataIntegrityViolationException e) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Existem dados duplicados");
		}
		log.info("[finaliza] VeiculoInfraRepository - salva ");
		return veiculo;
	}

	@Override
	public List<Veiculo> buscaTodosVeiculos() {
		log.info("[inicia] VeiculoInfraRepository - buscaTodosVeiculos ");
		var buscaVeiculos = veiculoSpringDataJPARepository.findAll();
		log.info("[finaliza] VeiculoInfraRepository - buscaTodosVeiculos ");
		return buscaVeiculos;
	}

	@Override
	public Veiculo buscaVeiculoPorId(UUID idVeiculo) {
		log.info("[inicia] VeiculoInfraRepository - buscaVeiculoPorId ");
		var buscaVeiculo = veiculoSpringDataJPARepository.findById(idVeiculo).orElseThrow(() -> APIException.build(HttpStatus.NOT_EXTENDED,
				"Veículo não encontrado, certifique-se que o id informado está correto"));
		log.info("[finaliza] VeiculoInfraRepository - buscaVeiculoPorId ");
		return buscaVeiculo;
	}

	@Override
	public void deleta(UUID idVeiculo) {
		log.info("[inicia] VeiculoInfraRepository - deleta ");
		veiculoSpringDataJPARepository.deleteById(idVeiculo);
		log.info("[inicia] VeiculoInfraRepository - deleta ");
	}

}
