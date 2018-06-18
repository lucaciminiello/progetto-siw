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
public class Centro {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String nome;

	@Column(nullable=true)
	private String email;

	@Column(nullable=true)
	private String indirizzo;

	@Column(nullable=true)
	private String numeroTelefono;

	@OneToOne
	private Responsabile responsabile;

	@OneToMany(mappedBy="centro")
	private List<Attività> attività;

	@OneToMany
	@JoinColumn(name="centro_id")
	private List<Allievo> allievi;

	public Centro() {}

	public Centro(String nome) {
		this.nome = nome;
		attività = new ArrayList<Attività>();
		allievi = new ArrayList<Allievo>(100);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public List<Attività> getAttività() {
		return attività;
	}

	public void setAttività(List<Attività> attività) {
		this.attività = attività;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	public Responsabile getResponsabile() {
		return responsabile;
	}

	public void setResponsabile(Responsabile responsabile) {
		this.responsabile = responsabile;
	}
}
