package com.fall.tp_spring.metier;

import com.fall.tp_spring.dao.JpaDao;
import com.fall.tp_spring.models.Produit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("jpaService")
public class JpaProduitServiceImpl implements IProduitService{
    private final JpaDao produitDAO;

    public JpaProduitServiceImpl(JpaDao produitDAO) {
        this.produitDAO =  produitDAO;
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
    public Optional<Produit> getProduitById(Long id) {
        return Optional.ofNullable(produitDAO.getProduitById(id));
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
