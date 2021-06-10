package br.edu.iftm.upt.resolucaocestasbasicasiftm.repository.helper.instituicao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.iftm.upt.resolucaocestasbasicasiftm.model.Instituicao;

public class InstituicaoQueriesImpl implements InstituicaoQueries {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Instituicao> buscarComCestasDisponiveis(int mes, int ano) {
		String jpql = "select i from Entrega e right join e.instituicao i where (select count(e2) from Entrega e2 where e2.instituicao = i and e2.ano = :ano and e2.mes = :mes) < i.nroCestasBasicasMes";		
		TypedQuery<Instituicao> query = manager.createQuery(jpql, Instituicao.class);
		query.setParameter("ano", ano);
		query.setParameter("mes", mes);
		List<Instituicao> instituicoes = query.getResultList();
		return instituicoes;
	}

}