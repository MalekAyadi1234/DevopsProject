package tn.esprit.rh.achat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.entities.CategorieProduit;

@Repository
public interface CategorieProduitRepository extends JpaRepository<CategorieProduit, Long>{
//categorie_produit
	@Query("SELECT s FROM categorie_produit s where s.idCategorieProduit > 0")
	List<CategorieProduit> retrieveStatusCategorie();
}
