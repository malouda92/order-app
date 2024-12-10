package com.commande.webapp.services;

import com.commande.webapp.entity.Produit;
import com.commande.webapp.repository.ProduitRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;


    @Override
    public List<Produit> getAllProducts() {
        return produitRepository.findAll();
    }

    @Override
    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit getProduit(String id) {
        Optional<Produit> returnedProduit = produitRepository.findById(id);
        return returnedProduit.orElse(null);
    }

    @Override
    @Transactional
    public Produit updateProduit(String id, Produit produitUpdated) {
        Optional<Produit> returnedProduit = produitRepository.findById(id);
        returnedProduit.ifPresent(produit -> {
            produit.setLibelle(produitUpdated.getLibelle());
            produit.setPackaging(produitUpdated.getPackaging());
            produit.setPoids(produit.getPoids());
            produit.setUnite(produitUpdated.getUnite());
        });
        return null;
    }

    @Override
    public void deleteProduit(String id) {
        Optional<Produit> returnedProduit = produitRepository.findById(id);
        returnedProduit.ifPresent(produitRepository::delete);
    }
}
