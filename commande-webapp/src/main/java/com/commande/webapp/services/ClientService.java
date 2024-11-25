package com.commande.webapp.services;



import com.commande.webapp.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();
    Client createClient(Client client);
    Client getClient(String id);
    Client updateClient(String id, Client clientUpdated);
    void deleteClient(String id);

}
