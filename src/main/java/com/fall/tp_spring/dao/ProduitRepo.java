package com.fall.tp_spring.dao;
import com.fall.tp_spring.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface ProduitRepo extends JpaRepository<Produit, Long> {
    @Query("SELECT p FROM Produit p WHERE p.designation LIKE %:keyword%")
    List<Produit> searchProduits(String keyword);
}
