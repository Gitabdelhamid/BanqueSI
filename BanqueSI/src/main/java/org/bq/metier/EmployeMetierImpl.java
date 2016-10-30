package org.bq.metier;

import java.util.List;

import org.bq.Entities.Employe;
import org.bq.dao.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeMetierImpl implements EmployeMetier {

	@Autowired
	private EmployeRepository employeRepository;

	public Employe saveEmploye(Employe e) {
		
		return employeRepository.save(e);
	}

	public List<Employe> listEmployes() {
		return employeRepository.findAll();
	}

}
