package br.edu.iftm.upt.resolucaocestasbasicasiftm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "familia")
public class Familia implements Serializable {

	private static final long serialVersionUID = -4222030752942379212L;

	@Id
	@SequenceGenerator(name="gerador", sequenceName="familia_codigo_seq", allocationSize=1)
	@GeneratedValue(generator="gerador", strategy=GenerationType.SEQUENCE)
	private Long codigo;
	@Column(name = "nome_aluno")
	private String nomeAluno;
	@Column(name = "numero_pessoas")
	private int nroPessoas;
	private String endereco;
	private String contato;
	@Column(name = "numero_salarios_minimos")
	private int nroSalariosMinimos;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public int getNroPessoas() {
		return nroPessoas;
	}

	public void setNroPessoas(int nroPessoas) {
		this.nroPessoas = nroPessoas;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public int getNroSalariosMinimos() {
		return nroSalariosMinimos;
	}

	public void setNroSalariosMinimos(int nroSalariosMinimos) {
		this.nroSalariosMinimos = nroSalariosMinimos;
	}

	@Override
	public String toString() {
		return "codigo: " + codigo + "\nnomeAluno: " + nomeAluno + "\nnroPessoas: " + nroPessoas + "\nendereco: "
				+ endereco + "\ncontato: " + contato + "\nnroSalariosMinimos: " + nroSalariosMinimos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Familia other = (Familia) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
