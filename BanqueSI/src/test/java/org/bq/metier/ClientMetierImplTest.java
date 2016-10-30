package org.bq.metier;

import static org.junit.Assert.assertEquals;

import org.bq.Entities.Client;
import org.bq.dao.ClientRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ClientMetierImplTest {
	
	@Autowired
	  ClientMetier clientMetier;
	 @Autowired
	ClientRepository c;

	@Test
	public void testSaveClient() {
		Client cli=new Client("nmCli", "adressCli");
		try {
			clientMetier.saveClient(cli);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		Client cc=  c.findOne(3L);
		assertEquals("nmCli",cc.getNomCli() );
		assertEquals("adressCli",cc.getAdressCli() );
		
	}

	@Test
	public void testListClients() {
//.getClass(assertEquals(3, clientMetier.ListClients().size());
	}

}
