package org.bq.metier;

import java.util.List;

import org.bq.Entities.Client;
import org.bq.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


//@Service cette anot est utilisé dans la couche metier 
//por indqué a spring que cetteclasse est un bean spring //@Component
@Component
@Service
public class ClientMetierImpl implements ClientMetier {
	@Autowired
	private ClientRepository clientRepository;
	
	public Client saveClient(Client c) {
		return clientRepository.save(c);
	}

	
	public List<Client> ListClients() {
		return clientRepository.findAll();
	}

}
