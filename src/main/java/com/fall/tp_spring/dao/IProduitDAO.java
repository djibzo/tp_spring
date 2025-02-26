package com.fall.tp_spring.dao;

import com.fall.tp_spring.models.Produit;

import java.util.List;

public interface IProduitDAO {
    void addProduit(Produit produit);
    List<Produit> getAllProduits();
    List<Produit> searchProduits(String keyword);
    Produit getProduitById(Long id);
    void updateProduit(Produit produit);
    void deleteProduit(Long id);
}
