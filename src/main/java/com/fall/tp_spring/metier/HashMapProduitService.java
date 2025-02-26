package com.fall.tp_spring.metier;

import com.fall.tp_spring.models.Produit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("hashMapService")
public class ProduitHashMapService implements IProduitService {

    // Utilisation de HashMap pour stocker les produits
    private final Map<String, Produit> produitsMap = new HashMap<>();

    @Override
    public void ajouterProduit(Produit produit) {

    }

    @Override
    public void modifierProduit(Produit produit) {

    }

    @Override
    public void supprimerProduit(Long id) {

    }

    @Override
    public Produit getProduitById(Long id) {
        return null;
    }

    @Override
    public List<Produit> getAllProduits() {
        return null;
    }

    @Override
    public List<Produit> rechercheProduit(String keyword) {
        return null;
    }
}
