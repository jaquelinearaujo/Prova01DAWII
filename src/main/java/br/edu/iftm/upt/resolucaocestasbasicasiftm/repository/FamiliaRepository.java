package br.edu.iftm.upt.resolucaocestasbasicasiftm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iftm.upt.resolucaocestasbasicasiftm.model.Familia;
import br.edu.iftm.upt.resolucaocestasbasicasiftm.repository.helper.familia.FamiliaQueries;

public interface FamiliaRepository extends JpaRepository<Familia, Long>, FamiliaQueries {

}
