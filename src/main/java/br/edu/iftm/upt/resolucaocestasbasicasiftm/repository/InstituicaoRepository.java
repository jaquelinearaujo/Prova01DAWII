package br.edu.iftm.upt.resolucaocestasbasicasiftm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iftm.upt.resolucaocestasbasicasiftm.model.Instituicao;
import br.edu.iftm.upt.resolucaocestasbasicasiftm.repository.helper.instituicao.InstituicaoQueries;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long>, InstituicaoQueries {

}
