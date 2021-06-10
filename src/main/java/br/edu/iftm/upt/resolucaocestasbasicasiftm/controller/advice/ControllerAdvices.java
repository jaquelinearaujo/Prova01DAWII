package br.edu.iftm.upt.resolucaocestasbasicasiftm.controller.advice;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice // Vai afetar todos os controladores
public class ControllerAdvices {

	private static final Logger logger = LoggerFactory.getLogger(ControllerAdvices.class);

	@ExceptionHandler(value = Exception.class)
	public String handleAllExceptions(HttpServletRequest request, Exception exception) {
		// ESQUEMA DO ID DO ERRO
		logger.error("A requisição {} lançou uma {}", request.getRequestURL(), exception);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exception.printStackTrace(pw);
		logger.error("Stack trace da exceção: {}", sw.toString());
		return "error";
	}

	@InitBinder
	private void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

}