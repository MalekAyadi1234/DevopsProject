package tn.esprit.rh.achat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CategorieProduitServiceImpl implements ICategorieProduitService {

	
	@Autowired
	CategorieProduitRepository categorieProduitRepository;
	@Override
	public List<CategorieProduit> retrieveAllCategorieProduits() {
		
		return categorieProduitRepository.findAll();
	}

	@Override
	public CategorieProduit addCategorieProduit(CategorieProduit cp) {
		categorieProduitRepository.save(cp);
		return cp;
	}

	@Override
	public void deleteCategorieProduit(Long id) {
		categorieProduitRepository.deleteById(id);
		
	}

	@Override
	public CategorieProduit updateCategorieProduit(CategorieProduit cp) {
		categorieProduitRepository.save(cp);
		return cp;
	}

	@Override
	public CategorieProduit retrieveCategorieProduit(Long id) {
		CategorieProduit categorieProduit = categorieProduitRepository.findById(id).orElse(null);
		return categorieProduit;
	}
	//retrieveStatusCategorie
	@Override
	public String retrieveStatusCategorie() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String msgDate = sdf.format(now);
		String finalMessage = "";
		String newLine = System.getProperty("line.separator");
		List<CategorieProduit> stocksEnRouge = (List<CategorieProduit>) categorieProduitRepository.retrieveStatusCategorie();
		for (int i = 0; i < stocksEnRouge.size(); i++) {
			finalMessage = newLine + finalMessage + msgDate + newLine + ": le stock "
					+ stocksEnRouge.get(i).getCodeCategorie() + " a une quantité de " + stocksEnRouge.get(i).getLibelleCategorie()
					+ " inférieur à la quantité minimale a ne pas dépasser de " + stocksEnRouge.get(i).getIdCategorieProduit()
					+ newLine;

		}
	//	log.info(finalMessage);
		return finalMessage;
	}

}
