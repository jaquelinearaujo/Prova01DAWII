package br.edu.iftm.upt.resolucaocestasbasicasiftm.repository.helper.familia;

import java.util.List;

import br.edu.iftm.upt.resolucaocestasbasicasiftm.model.Familia;

public interface FamiliaQueries {

	List<Familia> buscarComLimiteSalariosMinimos(int mes, int ano, int limiteSalariosMinimos);
	List<Familia> buscarNaoContempladas(int mes, int ano);
	
}
