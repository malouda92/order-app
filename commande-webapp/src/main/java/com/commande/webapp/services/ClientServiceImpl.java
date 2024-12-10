package com.commande.webapp.services;

import com.commande.webapp.entity.Client;
import com.commande.webapp.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClient(String id) {
        Optional<Client> returnedClient = clientRepository.findById(id);
        return returnedClient.orElse(null);
    }

    @Override
    @Transactional
    public Client updateClient(String id, Client clientUpdated) {
        Optional<Client> returnedClient = clientRepository.findById(id);
        returnedClient.ifPresent(client -> {
            client.setNom(clientUpdated.getNom());
            client.setPrenom(clientUpdated.getPrenom());
            client.setAdresse(clientUpdated.getAdresse());
            client.setTelephone(clientUpdated.getTelephone());
            client.setCommandes(clientUpdated.getCommandes());
        });
        return returnedClient.orElse(null);
    }

    @Override
    public void deleteClient(String id) {
        Optional<Client> returnedClient = clientRepository.findById(id);
        returnedClient.ifPresent(clientRepository::delete);
    }


}
