package org.bq.metier;

import java.util.Date;

import org.bq.Entities.Compte;
import org.bq.dao.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteMetierImpl implements CompteMetier {

	@Autowired 
	private CompteRepository compteRepository;
	
	public Compte saveCompte(Compte c) {
c.setDateCreation(new Date());
		return compteRepository.save(c);
		
	}

	public Compte getCompte(String code) {
		
		return compteRepository.findOne(code);
	}

}
