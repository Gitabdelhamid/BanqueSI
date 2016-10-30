package org.bq.Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateoperation, double montant) {
		super(dateoperation, montant);
		// TODO Auto-generated constructor stub
	}
	

}
