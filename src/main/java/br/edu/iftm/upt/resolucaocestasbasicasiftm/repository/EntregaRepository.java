package br.edu.iftm.upt.resolucaocestasbasicasiftm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iftm.upt.resolucaocestasbasicasiftm.model.Entrega;
import br.edu.iftm.upt.resolucaocestasbasicasiftm.repository.helper.entrega.EntregaQueries;

public interface EntregaRepository extends JpaRepository<Entrega, Long>, EntregaQueries {

}
