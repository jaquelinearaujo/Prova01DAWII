package br.edu.iftm.upt.resolucaocestasbasicasiftm.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.iftm.upt.resolucaocestasbasicasiftm.model.Entrega;
import br.edu.iftm.upt.resolucaocestasbasicasiftm.model.Familia;
import br.edu.iftm.upt.resolucaocestasbasicasiftm.model.Instituicao;
import br.edu.iftm.upt.resolucaocestasbasicasiftm.repository.EntregaRepository;
import br.edu.iftm.upt.resolucaocestasbasicasiftm.repository.FamiliaRepository;
import br.edu.iftm.upt.resolucaocestasbasicasiftm.repository.InstituicaoRepository;
import br.edu.iftm.upt.resolucaocestasbasicasiftm.service.EntregaService;

@Controller
@RequestMapping("/entrega")
public class EntregaController {

	private static final Logger logger = LoggerFactory.getLogger(EntregaController.class);
	
	@Autowired
	private InstituicaoRepository instituicaoRepository;
	
	@Autowired
	private FamiliaRepository familiaRepository;
	
	@Autowired
	private EntregaService entregaService;
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@PostMapping("/escolherinstituicao")
	public ModelAndView escolherInstituicao(Integer mes, Integer ano) {
		logger.trace("Entrou no método escolherInstituicao");
		logger.debug("Ano: {} e Mês: {} recebidos", ano, mes);
		ModelAndView mv = new ModelAndView("entrega/escolhainstituicao");
		mv.addObject("ano", ano);
		mv.addObject("mes", mes);
		List<Instituicao> instituicoes = instituicaoRepository.buscarComCestasDisponiveis(mes, ano);
		logger.debug("Instituições com cestas disponíveis: {}", instituicoes);
		mv.addObject("instituicoes", instituicoes);
		logger.trace("Encaminhando para a view entrega/escolhainstituicao");
		return mv;
	}
	
	@PostMapping("/escolherfamilia")
	public ModelAndView escolherFamilia(Integer mes, Integer ano, Long codigo) {
		logger.trace("Entrou no método escolherFamilia");
		logger.debug("Ano: {}, Mês: {} e codigo da instituicao: {} recebidos", ano, mes, codigo);
		ModelAndView mv = new ModelAndView("entrega/escolhafamilia");
		mv.addObject("ano", ano);
		mv.addObject("mes", mes);
		Optional<Instituicao> opt = instituicaoRepository.findById(codigo);
		Instituicao instituicao = opt.get();
		mv.addObject("instituicao", instituicao);
		List<Familia> familias = familiaRepository.buscarComLimiteSalariosMinimos(mes, ano, instituicao.getLimiteSalariosMinimos());
		logger.debug("Familias que podem receber cesta: {}", familias);
		mv.addObject("familias", familias);
		logger.trace("Encaminhando para a view entrega/escolhafamilia");
		return mv;
	}
	
	@PostMapping("/nova")
	public String nova(Integer mes, Integer ano, Instituicao instituicao, Long codigoFamilia, RedirectAttributes atributos) {
		logger.trace("Entrou no método nova");
		logger.debug("Ano: {}, Mês: {}, Instituicao: {} e codigo da Familia {} recebidos", ano, mes, instituicao, codigoFamilia);
		Optional<Familia> opt = familiaRepository.findById(codigoFamilia);
		Familia familia = opt.get();
		Entrega entrega = new Entrega();
		entrega.setMes(mes);
		entrega.setAno(ano);
		entrega.setInstituicao(instituicao);
		entrega.setFamilia(familia);
		logger.debug("Entrega a ser salva {}", entrega);
		entregaService.salvar(entrega);
		atributos.addFlashAttribute("mensagem", "Entrega cadastrada com sucesso");
		return "redirect:/mostrarmensagem";
	}
	
	
	@PostMapping("/relatorio")
	public ModelAndView relatorioEntregas(Integer mes, Integer ano) {
		logger.trace("Entrou no método escolherInstituicao");
		logger.debug("Ano: {} e Mês: {} recebidos", ano, mes);
		ModelAndView mv = new ModelAndView("entrega/relatorio");
		mv.addObject("ano", ano);
		mv.addObject("mes", mes);
		List<Entrega> entregas = entregaRepository.buscarComFamiliaInstituicao(mes, ano);
		logger.debug("Entregas feitas no mes e ano: {}", entregas);
		mv.addObject("entregas", entregas);
		logger.trace("Encaminhando para a view entrega/relatorio");
		return mv;
	}
	
}









