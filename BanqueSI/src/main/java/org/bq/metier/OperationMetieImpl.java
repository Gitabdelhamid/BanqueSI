package org.bq.metier;

import java.util.Date;

import org.bq.Entities.Compte;
import org.bq.Entities.Employe;
import org.bq.Entities.Operation;
import org.bq.Entities.Retrait;
import org.bq.Entities.Versement;
import org.bq.dao.CompteRepository;
import org.bq.dao.EmployeRepository;
import org.bq.dao.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationMetieImpl implements OperationMetier {
	@Autowired private OperationRepository operationRepository;
	@Autowired private CompteRepository compteRepository;
	@Autowired private EmployeRepository employeRepository;

	@Transactional
	public boolean versement(String codeCompte, double montant, long codeEmplye) {
			Compte cp=compteRepository.findOne(codeCompte);
			Employe emp=employeRepository.findOne(codeEmplye);
			Operation op=new Versement();
			op.setDateoperation(new Date());
			op.setCompte(cp);
			op.setEmploye(emp);
			op.setMontant(montant);
			operationRepository.save(op);
			cp.setSolde(cp.getSolde()+montant);
			return true;

	} 

	@Transactional
	public boolean retrait(String codeCompte, double montant, long codeEmplye) {
		Compte cp=compteRepository.findOne(codeCompte);
		Employe emp=employeRepository.findOne(codeEmplye);
		if (cp.getSolde()<montant) { throw new RuntimeException("Somde insufisant !");
				}
		Operation op=new Retrait();
		op.setDateoperation(new Date());
		op.setCompte(cp);
		op.setEmploye(emp);
		op.setMontant(montant);
		operationRepository.save(op);
		cp.setSolde(cp.getSolde()-montant);
		return true;
	}

	@Transactional
	public boolean virement(String codeCompte1, String codeCompte2, double montant, long codeEmplye) {

		retrait(codeCompte1, montant, codeEmplye);
		versement(codeCompte2, montant, codeEmplye);
		return true;
	}

}
