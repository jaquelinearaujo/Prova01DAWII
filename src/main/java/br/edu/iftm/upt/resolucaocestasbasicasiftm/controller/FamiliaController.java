package br.edu.iftm.upt.resolucaocestasbasicasiftm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.iftm.upt.resolucaocestasbasicasiftm.model.Familia;
import br.edu.iftm.upt.resolucaocestasbasicasiftm.repository.FamiliaRepository;

@Controller
@RequestMapping("/familia")
public class FamiliaController {

	private static final Logger logger = LoggerFactory.getLogger(FamiliaController.class);
	
	@Autowired
	private FamiliaRepository familiaRepository;
	
	@PostMapping("/relatorio")
	public ModelAndView relatorioFamiliasNaoContempladas(Integer mes, Integer ano) {
		logger.trace("Entrou no método relatorioFamiliasNaoContempladas");
		logger.debug("Ano: {} e Mês: {} recebidos", ano, mes);
		ModelAndView mv = new ModelAndView("familia/relatorio");
		mv.addObject("ano", ano);
		mv.addObject("mes", mes);
		List<Familia> familias = familiaRepository.buscarNaoContempladas(mes, ano);
		logger.debug("Familias buscadas: {}", familias);
		mv.addObject("familias", familias);
		logger.trace("Encaminhando para a view familia/relatorio");
		return mv;
	}
}