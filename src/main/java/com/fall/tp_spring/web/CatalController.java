package com.fall.tp_spring.web;
import com.fall.tp_spring.metier.IProduitService;
import com.fall.tp_spring.models.Produit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produits")
public class CatalController {

    private final IProduitService produitService;

    public CatalController(@Qualifier("hashmapService") IProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping
    public void addProduit(@RequestBody Produit produit) {
        produitService.ajouterProduit(produit);
    }

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/search")
    public List<Produit> searchProduits(@RequestParam String keyword) {
        return produitService.rechercheProduit(keyword);
    }

    @GetMapping("/{id}")
    public Optional<Produit> getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }

    @PutMapping("/{id}")
    public void updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        produit.setId(id);
        produitService.modifierProduit(produit);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.supprimerProduit(id);
    }
}
