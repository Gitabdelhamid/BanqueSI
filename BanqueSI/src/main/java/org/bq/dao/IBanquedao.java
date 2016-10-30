package org.bq.dao;
import org.bq.Entities.*;

import java.util.List;



public interface IBanquedao {
	public Client addCLient(Client c);
	public Employe addEmploye(Employe e,Long codSup);
	public Groupe addGroupe(Groupe d);
	public void addEmployeToGroupe(Long codEmp,Long codeGrp);
	public Compte addCompte(Compte cp,Long codeClient ,Long codeEmploye);
	public Operation addOperation(Operation op ,String codeCompte,Long codeEmplye);
	
	/*public void versement(String codeCompte,double mt,Long codeEmplye);
	public void retrait(String codeCompte,double mt,Long codeEmplye);
	public void virement(String codeCompte1,String codeCompte2,double mt,Long codeEmplye);
*/
	public Compte consulterCompte(String codeCompte);
	public List<Operation> consulterOperations(String codeCompte);
	public Client consulterClient(Long codeClient);
	public List<Client> cosulterClients(String motCle);
	public List< Compte> getComptesByClient(Long codClient);
	public List< Compte> getComptesByEmplye(Long codEmpliye);
	public List< Employe> getEmployes();
	public List< Groupe> getGroupes();
	public List< Employe> getEmployeByGroupe(Long codeGroupe);
	
	
	

}
