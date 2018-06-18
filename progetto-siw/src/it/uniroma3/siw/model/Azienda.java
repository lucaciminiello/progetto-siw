package it.uniroma3.siw.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Azienda {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String nome;

	@OneToMany
	@JoinColumn(name="azienda_id")
	private List<Centro> centri;

	@OneToOne
	private Responsabile direttore;

	public Azienda() {}

	public Azienda(String nome) {
		this.nome = nome;
		this.centri = new ArrayList<Centro>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Centro> getCentri() {
		return centri;
	}

	public void setCentri(List<Centro> centri) {
		this.centri = centri;
	}

	public Responsabile getDirettore() {
		return direttore;
	}

	public void setDirettore(Responsabile direttore) {
		this.direttore = direttore;
	}
}
