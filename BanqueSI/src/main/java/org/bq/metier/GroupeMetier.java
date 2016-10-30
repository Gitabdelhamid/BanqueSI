package org.bq.metier;

import java.util.List;

import org.bq.Entities.Groupe;

public interface GroupeMetier {
	public Groupe saveGroupe(Groupe g);
	public List<Groupe> listGroupes();

}
