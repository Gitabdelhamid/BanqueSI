package org.bq.Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity

public class Groupe implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codeGroupe;
	private String nomGroupe;
	/*puisq la relation  est d�ja d�fini dant l'assosiation des empl on utilise just maped by  */
	@ManyToMany(mappedBy="groupes")
	/*un groupe contient plusieurs employee*/
	private Collection<Employe> employes;
	
	
	public long getCodeGroupe() {
		return codeGroupe;
	}
	public void setCodeGroupe(long codeGroupe) {
		this.codeGroupe = codeGroupe;
	}
	public String getNomGroupe() {
		return nomGroupe;
	}
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	public Collection<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}
	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
