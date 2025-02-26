package com.fall.tp_spring.dao;

import com.fall.tp_spring.models.Produit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jpaDao")
public class JpDao implements IProduitDAO {

    ProduitRepo jpaDao;
    @Override
    public void addProduit(Produit produit) {
        jpaDao.save(produit);
    }

    @Override
    public List<Produit> getAllProduits() {
        return null;
    }

    @Override
    public List<Produit> searchProduits(String keyword) {
        return null;
    }

    @Override
    public Produit getProduitById(Long id) {
        return null;
    }

    @Override
    public void updateProduit(Produit produit) {

    }

    @Override
    public void deleteProduit(Long id) {

    }
}
