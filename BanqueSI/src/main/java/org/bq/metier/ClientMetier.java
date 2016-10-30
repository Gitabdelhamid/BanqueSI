package org.bq.metier;

import java.util.List;

import org.bq.Entities.Client;

public interface ClientMetier {
	public Client saveClient(Client c);
	public List<Client> ListClients();

}
