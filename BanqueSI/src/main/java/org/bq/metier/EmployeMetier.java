package org.bq.metier;

import java.util.List;

import org.bq.Entities.Employe;

public interface EmployeMetier {
 public Employe saveEmploye(Employe e);
 public List<Employe> listEmployes();
}
