package org.bq.Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
//et puisq c� ue class fille de compte 
@DiscriminatorValue("CC")
public class CompteCourent extends Compte{
	 private double decouvert;

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public CompteCourent(String codeCompte, Date dateCreation, double solde,
			double decouvert) {
		super(codeCompte, dateCreation, solde);
		this.decouvert = decouvert;
	}

	public CompteCourent() {
		super();
		// TODO Auto-generated constructor stub
	}


	 

}
