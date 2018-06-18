package it.uniroma3.siw.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Attività{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String nome;

	@Column(nullable=false)
	private String giorno;

	@Column(nullable=false)
	private Integer oraInizio;

	@Column(nullable=false)
	private Integer oraFine;

	@ManyToMany
	@JoinTable(name="attività_allievo", joinColumns=@JoinColumn(name="attività_id", nullable=false, updatable=false),
	inverseJoinColumns=@JoinColumn(name="allievi_id", nullable=false, updatable=false))
	private List<Allievo> allievi;

	@ManyToOne
	private Centro centro;

	public Attività(String nome, String giorno, Integer oraInizio, Integer oraFine){
		this.allievi = new ArrayList<Allievo>();
		this.nome = nome;
		this.giorno = giorno;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
	}


	public Attività() {}

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

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

	public String getGiorno() {
		return giorno;
	}

	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}

	public Integer getOraInizio() {
		return oraInizio;
	}

	public void setOraInizio(Integer oraInizio) {
		this.oraInizio = oraInizio;
	}

	public Integer getOraFine() {
		return oraFine;
	}

	public void setOraFine(Integer oraFine) {
		this.oraFine = oraFine;
	}
}
