package org.bq.service;

import org.bq.metier.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationRestService {
	@Autowired
	private OperationMetier operationMetier;
	
	
@RequestMapping(value="versement",method=RequestMethod.PUT)
	public boolean versement(@RequestParam String codeCompte,
			@RequestParam double montant,
			@RequestParam long codeEmplye) {
		return operationMetier.versement(codeCompte, montant, codeEmplye);
	}
@RequestMapping(value="retrait",method=RequestMethod.PUT)
	public boolean retrait(@RequestParam String codeCompte,
			@RequestParam double montant,
			@RequestParam long codeEmplye) {
		return operationMetier.retrait(codeCompte, montant, codeEmplye);
	}
@RequestMapping(value="virement",method=RequestMethod.PUT)
	public boolean virement(@RequestParam String codeCompte1, 
			@RequestParam String codeCompte2,
			@RequestParam double montant,
			@RequestParam long codeEmplye) {
		return operationMetier.virement(codeCompte1, codeCompte2, montant, codeEmplye);
	}

}
