package com.commande.webapp.services;

import com.commande.webapp.entity.Produit;

import java.util.List;

public interface ProduitService {
    List<Produit> getAllProducts();
    Produit createProduit(Produit produit);
    Produit getProduit(String id);
    Produit updateProduit(String id, Produit produitUpdated);
    void deleteProduit(String id);
}
