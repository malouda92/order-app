package com.commande.webapp.controller;

import com.commande.webapp.api.ProduitApi;
import com.commande.webapp.mapper.ProduitMapper;
import com.commande.webapp.model.Produit;
import com.commande.webapp.services.ProduitServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProduitController implements ProduitApi {

    private final ProduitServiceImpl produitService;
    private final ProduitMapper produitMapper;

    @Override
    @PostMapping("/api/produit")
    public ResponseEntity<Produit> addProduit(@RequestBody Produit produit) {
        return ResponseEntity.ok().body(produitMapper.produitEntityToModel(produitService.createProduit(produitMapper.produitModelToEntity(produit))));
    }

    @Override
    @DeleteMapping("/api/produit/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable String id) {
        produitService.deleteProduit(id);
        return ResponseEntity.ok().body(null);
    }

    @Override
    @GetMapping("/api/produit/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable String id) {
        return ResponseEntity.ok().body(produitMapper.produitEntityToModel(produitService.getProduit(id)));
    }

    @Override
    @GetMapping("/api/produits")
    public ResponseEntity<List<Produit>> getProduits() {
        return ResponseEntity.ok().body(produitMapper.produitEntitiesToModels(produitService.getAllProducts()));
    }

    @Override
    @PutMapping("/api/produit/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable String id, @RequestBody Produit produit) {
        return ResponseEntity.ok().body(produitMapper.produitEntityToModel(produitService.updateProduit(id, produitMapper.produitModelToEntity(produit))));
    }
}
