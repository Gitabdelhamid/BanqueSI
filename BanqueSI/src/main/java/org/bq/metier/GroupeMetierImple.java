package org.bq.metier;

import java.util.List;

import org.bq.Entities.Groupe;
import org.bq.dao.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupeMetierImple implements GroupeMetier{
 @Autowired
	private GroupeRepository groupeRepository;
 
	public Groupe saveGroupe(Groupe g) {
		return groupeRepository.save(g);
	}

	@Override
	public List<Groupe> listGroupes() {
		return groupeRepository.findAll();
	}

}
