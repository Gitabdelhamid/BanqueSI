package org.bq.metier;

public interface OperationMetier {
	
	public boolean versement(String codeCompte,double montant,long codeEmplye);
	public boolean retrait(String codeCompte,double montant,long codeEmplye);
	public boolean virement(String codeCompte1,String codeCompte2,double montant,long codeEmplye);

}
