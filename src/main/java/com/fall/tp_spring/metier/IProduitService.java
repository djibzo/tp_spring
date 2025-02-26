package com.fall.tp_spring.metier;

import com.fall.tp_spring.models.Produit;

import java.util.List;
import java.util.Optional;

public interface IProduitService {
    void ajouterProduit(Produit produit);
    void modifierProduit(Produit produit);
    void supprimerProduit(Long id);
    Optional<Produit> getProduitById(Long id);
    List<Produit> getAllProduits();
    List<Produit> rechercheProduit(String keyword);
}
