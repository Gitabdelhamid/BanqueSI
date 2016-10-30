package org.bq.Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Date dateoperation, double montant) {
		super(dateoperation, montant);
		// TODO Auto-generated constructor stub
	}
	

}
