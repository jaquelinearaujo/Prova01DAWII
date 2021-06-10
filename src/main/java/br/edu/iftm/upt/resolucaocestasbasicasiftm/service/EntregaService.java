package br.edu.iftm.upt.resolucaocestasbasicasiftm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.iftm.upt.resolucaocestasbasicasiftm.model.Entrega;
import br.edu.iftm.upt.resolucaocestasbasicasiftm.repository.EntregaRepository;

@Service
public class EntregaService {

	private static final Logger logger = LoggerFactory.getLogger(EntregaService.class);

	@Autowired
	private EntregaRepository entregaRepository;

	@Transactional
	public void salvar(Entrega entrega) {
		logger.trace("Entrou em salvar");
		logger.debug("Salvando a Entrega {}", entrega);
		entregaRepository.save(entrega);
		logger.debug("Entrega salva com sucesso {}", entrega);
	}
}