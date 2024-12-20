package com.commande.webapp.controller;

import com.commande.webapp.api.ClientApi;
import com.commande.webapp.mapper.ClientMapper;
import com.commande.webapp.model.Client;
import com.commande.webapp.services.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController implements ClientApi {

    private final ClientServiceImpl clientService;
    private final ClientMapper clientMapper;

    @Override
    @PostMapping("/api/clients")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        return ResponseEntity.ok().body(clientMapper.clientEntityToModel(clientService.createClient(clientMapper.clientModelToEntity(client))));
    }

    @Override
    @DeleteMapping("/api/clients/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().body(null);
    }

    @Override
    @GetMapping("/api/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable String id) {
        return ResponseEntity.ok().body(clientMapper.clientEntityToModel(clientService.getClient(id)));
    }

    @Override
    @GetMapping("/api/clients")
    public ResponseEntity<List<Client>> getClients() {
        return ResponseEntity.ok().body(clientMapper.clientEntitiesToModels(clientService.getAllClients()));
    }

    @Override
    @PutMapping("/api/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable String id, Client client) {
        return ResponseEntity.ok().body(clientMapper.clientEntityToModel(clientService.updateClient(id, clientMapper.clientModelToEntity(client))));
    }
}
