package org.bq.service;

import java.security.acl.Group;
import java.util.List;

import org.bq.Entities.Groupe;
import org.bq.metier.GroupeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupeRestService {
	@Autowired
	private GroupeMetier groupeMetier;

	@RequestMapping(value="/groupes",method=RequestMethod.POST)
	public Groupe saveGroupe(@RequestBody Groupe g) {
		return groupeMetier.saveGroupe(g);
	}

	@RequestMapping(value="/groupes",method=RequestMethod.GET)
	public List<Groupe> listGroupes() {
		return groupeMetier.listGroupes();
	}

}
