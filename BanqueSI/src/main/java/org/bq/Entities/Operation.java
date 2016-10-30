package org.bq.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity 
//et puisq il ya h�ritage enutilise inh
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//on utilise un seul table
//@DiscriminatorColumn(name="TYPE_COMPTE",discriminatorType=DiscriminatorType.STRING,length=4)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")//.As,property="type"))//cet anotaion permet de faire le maping onjet/Json
@JsonSubTypes({
	@Type(name="V",value=Versement.class),
	@Type(name="R",value=Retrait.class)
})

public class Operation implements Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numOperation;
	private Date dateoperation;
	private double montant;
	
	@ManyToOne
	@JoinColumn(name="codeCompte")
		/*association Operation Apartient a un compte */
	private Compte compte;
	
	@ManyToOne
	@JoinColumn(name="codeEmploye")
	/*association Operation creer par un employee */
	private Employe employe;
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*pour le constructeur avec params on d�clare pa les associations*/
	public Operation(Date dateoperation, double montant) {
		super();
		this.dateoperation = dateoperation;
		this.montant = montant;
	}
	public Long getNumOperation() {
		return numOperation;
	}
	public void setNumOperation(Long numOperation) {
		this.numOperation = numOperation;
	}
	public Date getDateoperation() {
		return dateoperation;
	}
	public void setDateoperation(Date dateoperation) {
		this.dateoperation = dateoperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	

}
