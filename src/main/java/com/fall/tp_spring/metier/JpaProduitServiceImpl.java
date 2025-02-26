package com.fall.tp_spring.metier;

import com.fall.tp_spring.dao.IProduitDAO;
import com.fall.tp_spring.models.Produit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements IProduitService{
    private final IProduitDAO produitDAO;

    public ProduitServiceImpl(IProduitDAO produitDAO) {
        this.produitDAO = produitDAO;
    }
    @Override
    public void ajouterProduit(Produit produit) {
        produitDAO.addProduit(produit);
    }

    @Override
    public void modifierProduit(Produit produit) {
        produitDAO.updateProduit(produit);
    }

    @Override
    public void supprimerProduit(Long id) {
        produitDAO.deleteProduit(id);
    }

    @Override
    public Produit getProduitById(Long id) {
        return produitDAO.getProduitById(id);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitDAO.getAllProduits();
    }

    @Override
    public List<Produit> rechercheProduit(String keyword) {
        return produitDAO.searchProduits(keyword);
    }
}
