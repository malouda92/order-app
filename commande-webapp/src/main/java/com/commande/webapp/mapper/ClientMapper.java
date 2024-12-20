package com.commande.webapp.mapper;

import com.commande.webapp.model.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client clientEntityToModel(com.commande.webapp.entity.Client client);
    com.commande.webapp.entity.Client clientModelToEntity(Client client);
    List<Client> clientEntitiesToModels(List<com.commande.webapp.entity.Client> clients);
}
