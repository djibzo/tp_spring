package com.fall.tp_spring.dao;
import com.fall.tp_spring.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("jpaDao")
public interface JpaDAO extends JpaRepository<Produit, Long> {
    List<Produit> findByDesignation(String keyword);

    List<Produit> searchProduits(String keyword);
}
