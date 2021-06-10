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
@Table(name = "instituicao")
public class Instituicao implements Serializable {

	private static final long serialVersionUID = -7115942570524590913L;
	
	@Id
	@SequenceGenerator(name="gerador", sequenceName="insituicao_codigo_seq", allocationSize=1)
	@GeneratedValue(generator="gerador", strategy=GenerationType.SEQUENCE)
	private Long codigo;
	private String nome;
	private String endereco;
	private String contato;
	@Column(name = "numero_cestas_basicas_mes")
	private int nroCestasBasicasMes;
	@Column(name = "limite_salarios_minimos")
	private int limiteSalariosMinimos;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public int getNroCestasBasicasMes() {
		return nroCestasBasicasMes;
	}

	public void setNroCestasBasicasMes(int nroCestasBasicasMes) {
		this.nroCestasBasicasMes = nroCestasBasicasMes;
	}

	public int getLimiteSalariosMinimos() {
		return limiteSalariosMinimos;
	}

	public void setLimiteSalariosMinimos(int limiteSalariosMinimos) {
		this.limiteSalariosMinimos = limiteSalariosMinimos;
	}

	@Override
	public String toString() {
		return "codigo: " + codigo + "\nnome: " + nome + "\nendereco: " + endereco + "\ncontato: " + contato
				+ "\nnroCestasBasicasMes: " + nroCestasBasicasMes + "\nlimiteSalariosMinimos: " + limiteSalariosMinimos;
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
		Instituicao other = (Instituicao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
