package org.bq.Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Employe implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codeEmploye;
	private String nomEmploye;
	
	@ManyToOne
	@JoinColumn(name="employeSup")
	/*association empl possede empl superieur*/
	private Employe employeSup;
	
	@ManyToMany
	/*puisq on a @ManyToMany il fo utiluser une joiture table*/
	@JoinTable(name="EMPL_GRP",
	joinColumns=@JoinColumn(name="code_Employe"),inverseJoinColumns=@JoinColumn(name="code_Groupe"))
	/*associaton un empl apartient a plusieur groupes*/
private Collection<Groupe> groupes;
	
	

	public Long getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	public Employe getEmployeSup() {
		return employeSup;
	}
	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}
	@JsonIgnore
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	public Employe(String nomEmploye, Employe employeSup) {
		super();
		this.nomEmploye = nomEmploye;
		this.employeSup = employeSup;
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
