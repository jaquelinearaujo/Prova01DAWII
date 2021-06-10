package br.edu.iftm.upt.resolucaocestasbasicasiftm.repository.helper.instituicao;

import java.util.List;

import br.edu.iftm.upt.resolucaocestasbasicasiftm.model.Instituicao;

public interface InstituicaoQueries {

	List<Instituicao> buscarComCestasDisponiveis(int mes, int ano);
	
}
