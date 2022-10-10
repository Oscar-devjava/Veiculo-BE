package br.com.tinnova.veiculo.veiculo.application.repository;

import java.util.List;

import br.com.tinnova.veiculo.veiculo.domain.Veiculo;

public interface VeiculoRepository {

	Veiculo salva(Veiculo veiculo);

	List<Veiculo> buscaTodosVeiculos();

}
