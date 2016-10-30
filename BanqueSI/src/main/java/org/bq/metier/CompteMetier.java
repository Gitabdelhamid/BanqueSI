package org.bq.metier;

import java.util.List;

import org.bq.Entities.Compte;

public interface CompteMetier {
	public Compte saveCompte(Compte c);
	public Compte getCompte(String code);
}
