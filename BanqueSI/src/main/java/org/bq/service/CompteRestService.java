package org.bq.service;

import org.bq.Entities.Compte;
import org.bq.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompteRestService {
	@Autowired
	private CompteMetier compteMetier;

	@RequestMapping(value = "/comptes", method = RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte c) {
		return compteMetier.saveCompte(c);
	}

	@RequestMapping(value = "/comptes/{codeCompte}", method = RequestMethod.GET)
	public Compte getCompte(@PathVariable String codeCompte) {
		return compteMetier.getCompte(codeCompte);
	}

}
