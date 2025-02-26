package com.fall.tp_spring.dao;

import com.fall.tp_spring.models.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("jpaDao")
public class JpaDao implements IProduitDAO {

    @Autowired
    ProduitRepo jpaDao;
    @Override
    public void addProduit(Produit produit) {
        jpaDao.save(produit);
    }

    @Override
    public List<Produit> getAllProduits() {
        return new ArrayList<>(jpaDao.findAll());
    }

    @Override
    public List<Produit> searchProduits(String keyword) {
        return jpaDao.searchProduits(keyword);
    }

    @Override
    public Produit getProduitById(Long id) {
        return jpaDao.findById(id).get();
    }

    @Override
    public void updateProduit(Produit produit) {
        jpaDao.save(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        jpaDao.deleteById(id);
    }
}
