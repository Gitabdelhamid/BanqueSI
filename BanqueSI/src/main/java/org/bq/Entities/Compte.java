package org.bq.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;



//ces trois anotaion permet de faire le maping onjet/Xml
@Entity
//pour stocker les classe hirit�es dans un seul table on utilise @Inheritance
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
/*por specifier le type de compte*/
@DiscriminatorColumn(name="TYPE_COMPTE",discriminatorType=DiscriminatorType.STRING,length=4)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")//.As,property="type"))//cet anotaion permet de faire le maping onjet/Json
@JsonSubTypes({
	@Type(name="CC",value=CompteCourent.class),
	@Type(name="CE",value=CompteEpargne.class)
})
public abstract class Compte implements Serializable {
	@Id
	private String codeCompte;
	private Date dateCreation;
	private double solde;
	@ManyToOne  //puisq il saji de manytoOne il fo d�fnir une jointure cad cl� etrang�re
	//cl� �trang�re
	@JoinColumn(name="codCli")
	/*un compte apartient a un client (pou faire l'association 
	 * il faut d�clarer un objet de type client)*/
	private Client client;
	
	@ManyToOne
	//cl� �trang�re
	@JoinColumn(name="codeEmploye")
	/*un compte est creer par un employee(pour faire l'association 
	 * il faut d�clarer un objet de type employee)*/
	private Employe employe;
	
	
	@OneToMany(mappedBy="compte")
	/*Un compte peut subir plusieur operations
	 * (pour faire l'association  il faut d�clarer une  des operations)*/
	private Collection<Operation> operations;
	
	
	public String getCodeCompte() {
		return codeCompte;
	}
	
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	@JsonIgnore
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	/*pour le constructeur avec params on d�clare pa les associations*/
	public Compte(String codeCompte, Date dateCreation, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
