package br.edu.iftm.upt.resolucaocestasbasicasiftm.repository.helper.entrega;

import java.util.List;

import br.edu.iftm.upt.resolucaocestasbasicasiftm.model.Entrega;

public interface EntregaQueries {

	List<Entrega> buscarComFamiliaInstituicao(int mes, int ano);
	
}
