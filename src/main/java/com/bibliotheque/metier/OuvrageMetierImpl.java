package com.bibliotheque.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.OuvrageRepository;
import com.bibliotheque.entities.Ouvrage;

@Service
public class OuvrageMetierImpl implements OuvrageMetier{

	@Autowired
	private OuvrageRepository ouvrageRepository;
		
	@Override
	public void saveOuvrage(Ouvrage ouvrage) {
		ouvrageRepository.save(ouvrage);
	}

	@Override
	public void deleteOuvrage(Long id) {
		ouvrageRepository.deleteById(id);
	}

	@Override
	public Ouvrage getOuvrage(Long id) {		
		return ouvrageRepository.findById(id).orElse(null);
	}

	@Override
	public PageOuvrage listOuvrage( String mc, int page, int size) {
		
		Page<Ouvrage> ouvrages = ouvrageRepository.getListOuvrages("%" + mc + "%" ,PageRequest.of(page, size));
	
		PageOuvrage pageOuvrage = new PageOuvrage();
		pageOuvrage.setOuvrages(ouvrages.getContent());
		pageOuvrage.setNombreOuvrages(ouvrages.getNumberOfElements());
		pageOuvrage.setPage(ouvrages.getNumber());
		pageOuvrage.setTotalPage(ouvrages.getTotalPages());
		pageOuvrage.setTotalOuvrages((int) ouvrages.getTotalElements());
			
		return pageOuvrage;
	}

}