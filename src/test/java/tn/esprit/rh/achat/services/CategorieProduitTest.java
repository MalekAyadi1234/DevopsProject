package tn.esprit.rh.achat.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.anyLong;

import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

@SpringBootTest
 class CategorieProduitTest {

@MockBean
CategorieProduitRepository repo;
@Autowired
CategorieProduitServiceImpl srvce;







@Test

void TestretrieveAllCategories()

{

	CategorieProduit cat1 = new CategorieProduit("TestMock1","TestMock");
	CategorieProduit cat2= new CategorieProduit("TestMock2","TestMock");
CategorieProduit cat3 = new CategorieProduit("TestMock3","TestMock");
List<CategorieProduit> cats = Arrays.asList(cat1,cat2,cat3) ;



//ngolo biha le repo traje3li data li f list stocks l 3malnha statique
BDDMockito.given(repo.findAll()).willReturn(cats);



//test

assertThat(srvce.retrieveAllCategorieProduits()).hasSize(3).contains(cat1,cat2,cat3);



}

@Test

void TestretrieveCategories()

{

	CategorieProduit cat1 = new CategorieProduit("TestMock4","TestMock");
BDDMockito.given(repo.findById(anyLong())).willReturn(Optional.ofNullable(cat1));
CategorieProduit result = srvce.retrieveCategorieProduit(1L);
assertThat(result.getLibelleCategorie()).containsIgnoringCase("TestMock");

}



@Test

void TestaddCategorie()

{

	CategorieProduit cat1 = new CategorieProduit("TestMock5","TestMock");
when(repo.save(cat1)).thenReturn(cat1);
assertEquals(cat1, srvce.addCategorieProduit(cat1));

}



@Test

void TestupdateCategorie()

{

	CategorieProduit cat1 = new CategorieProduit("TestMock6","TestMock");
when(repo.save(cat1)).thenReturn(cat1);
cat1.setLibelleCategorie("update categorie");
cat1.setCodeCategorie("123");
assertEquals(cat1, srvce.updateCategorieProduit(cat1));

}





/*

@Test

void TestdeleteStock()

{

Stock stock = new Stock(1L,"addStock",100,50);
BDDMockito.given(repo.findById(anyLong())).willReturn(Optional.ofNullable(stock));
srvce.deleteStock(stock.getIdStock());
assertEquals(stock, srvce.deleteStock(stock.getIdStock()));

}

*/

@Test
void TestretrieveStatusCategorie ()

{

}

















}