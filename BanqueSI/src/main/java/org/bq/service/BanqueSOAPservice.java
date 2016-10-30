package org.bq.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.bq.Entities.Compte;
import org.bq.metier.CompteMetier;
import org.bq.metier.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebService(serviceName="BanqueSOAP")
public class BanqueSOAPservice {
	
	@Autowired
	private OperationMetier operationMetier;
	@Autowired
	private CompteMetier compteMetier;
	
	@WebMethod
	public boolean versement(@WebParam(name="codeCompte") String codeCompte,
			@WebParam(name="montant") double montant,
			@WebParam(name="codeEmplye") long codeEmplye) {
		return operationMetier.versement(codeCompte, montant, codeEmplye);
	}
	@WebMethod
	public boolean retrait(@WebParam(name="codeCompte") String codeCompte,
			@WebParam(name="montant") double montant,
			@WebParam(name="codeEmplye") long codeEmplye) {
		return operationMetier.retrait(codeCompte, montant, codeEmplye);
	}
	@WebMethod
	public boolean virement(@WebParam(name="codeCompte1") String codeCompte1,
			@WebParam(name="codeCompte2") String codeCompte2,
			@WebParam(name="montant") double montant,
			@WebParam(name="codeEmplye") long codeEmplye) {
		return operationMetier.virement(codeCompte1, codeCompte2, montant, codeEmplye);
	}
	@WebMethod
	public Compte getCompte(@WebParam(name="code") String code) {
		return compteMetier.getCompte(code);
	}

	

}
