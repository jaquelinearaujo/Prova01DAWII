package br.edu.iftm.upt.resolucaocestasbasicasiftm.repository.helper.entrega;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.annotations.QueryHints;
import org.springframework.transaction.annotation.Transactional;

import br.edu.iftm.upt.resolucaocestasbasicasiftm.model.Entrega;

public class EntregaQueriesImpl implements EntregaQueries {

	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public List<Entrega> buscarComFamiliaInstituicao(int mes, int ano) {
		String jpql = "select distinct e from Entrega e left join fetch e.familia f where e.ano = :ano and e.mes = :mes";		
		TypedQuery<Entrega> query = manager.createQuery(jpql, Entrega.class);
		query.setParameter("ano", ano);
		query.setParameter("mes", mes);
		query.setHint(QueryHints.PASS_DISTINCT_THROUGH, false);
		List<Entrega> entregas = query.getResultList();
		jpql = "select distinct e from Entrega e left join fetch e.instituicao i where e in :entregas";		
		query = manager.createQuery(jpql, Entrega.class);
		query.setParameter("entregas", entregas);
		query.setHint(QueryHints.PASS_DISTINCT_THROUGH, false);
		entregas = query.getResultList();
		return entregas;
	}

}