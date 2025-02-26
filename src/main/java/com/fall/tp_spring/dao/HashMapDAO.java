package com.fall.tp_spring.dao;

import com.fall.tp_spring.models.Produit;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("hashmapDao")
public class HashMapDAO implements IProduitDAO{
    private final Map<Long,Produit> produitMap=new HashMap<>();
    private Long currentId=1L;
    @Override
    public void addProduit(Produit produit) {
        produit.setId(currentId++);
        produitMap.put(produit.getId(),produit);
    }

    @Override
    public List<Produit> getAllProduits() {
        return new ArrayList<>(produitMap.values());
    }

    @Override
    public List<Produit> searchProduits(String keyword) {
        return produitMap.values().stream()
                .filter(p->p.getDesignation().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .toList();
    }

    @Override
    public Produit getProduitById(Long id) {
        return produitMap.get(id);
    }

    @Override
    public void updateProduit(Produit produit) {
     produitMap.put(produit.getId(),produit);
    }

    @Override
    public void deleteProduit(Long id) {
       produitMap.remove(id);
    }
}
