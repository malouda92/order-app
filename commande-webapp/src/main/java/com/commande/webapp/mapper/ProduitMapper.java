package com.commande.webapp.mapper;

import com.commande.webapp.entity.Produit;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProduitMapper {
    Produit produitModelToEntity(com.commande.webapp.model.Produit produit);
    com.commande.webapp.model.Produit produitEntityToModel(Produit produit);
    List<Produit> produitModelsToEntities(List<com.commande.webapp.model.Produit> produits);
    List<com.commande.webapp.model.Produit> produitEntitiesToModels(List<Produit> produits);
}
