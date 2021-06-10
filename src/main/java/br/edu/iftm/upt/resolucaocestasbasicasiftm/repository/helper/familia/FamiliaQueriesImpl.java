package br.edu.iftm.upt.resolucaocestasbasicasiftm.repository.helper.familia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.iftm.upt.resolucaocestasbasicasiftm.model.Familia;

public class FamiliaQueriesImpl implements FamiliaQueries {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Familia> buscarComLimiteSalariosMinimos(int mes, int ano, int limiteSalariosMinimos) {
		String jpql = "select f from Entrega e right join e.familia f where (select count(e2) from Entrega e2 where e2.familia = f and e2.ano = :ano and e2.mes = :mes) = 0 and f.nroSalariosMinimos <= :limiteSalariosMinimos";		
		TypedQuery<Familia> query = manager.createQuery(jpql, Familia.class);
		query.setParameter("ano", ano);
		query.setParameter("mes", mes);
		query.setParameter("limiteSalariosMinimos", limiteSalariosMinimos);
		List<Familia> familias = query.getResultList();
		return familias;
	}
	
	
	@Override
	public List<Familia> buscarNaoContempladas(int mes, int ano) {
		String jpql = "select f from Entrega e right join e.familia f where (select count(e2) from Entrega e2 where e2.familia = f and e2.ano = :ano and e2.mes = :mes) = 0";		
		TypedQuery<Familia> query = manager.createQuery(jpql, Familia.class);
		query.setParameter("ano", ano);
		query.setParameter("mes", mes);
		List<Familia> familias = query.getResultList();
		return familias;
	}
}