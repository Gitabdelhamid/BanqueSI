package org.bq.Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.criteria.Fetch;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CLIENT")
public class Client implements Serializable {
	@Id
	/*pour g�n�rer le code automatiquement*/
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="COD_CLIENT")
	private long codCli;
	private String nomCli;
	private String adressCli;
	
	
	/*l'asssociation est une collection on utlise alors @one to many*/
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	//un client peut avoir plusieurs comptes donc on doit declarer
	//une collection des comptes pour l'association
	private Collection<Compte> comptes;
	
	
	public long getCodCli() {
		return codCli;
	}
	public void setCodCli(long codCli) {
		this.codCli = codCli;
	}
	public String getNomCli() {
		return nomCli;
	}
	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}
	/*le constructeur sans param est exig� par JPA/hibernate*/
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAdressCli() {
		return adressCli;
	}
	public void setAdressCli(String adressCli) {
		this.adressCli = adressCli;
	}
	@JsonIgnore
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	/*pour le constructeur avec params on d�clare pa les associations*/
	public Client(String nomCli, String adressCli) {
		super();
		this.nomCli = nomCli;
		this.adressCli = adressCli;
	}
	
	

}
