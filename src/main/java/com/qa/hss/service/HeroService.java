package com.qa.hss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.hss.domain.Hero;
import com.qa.hss.repo.HeroRepo;

@Service
public class HeroService {

	private HeroRepo repo;
	
	@Autowired
	public HeroService(HeroRepo repo) {
		super();
		this.repo = repo;
	}
	
	//CRUD FUNCTIONALITY
	
	//Create
	public Hero createHero(Hero hero) {
		Hero createdHero = repo.save(hero);
		return createdHero;
	}
	
	//Read all
	public List<Hero> readAllHero(){
		return repo.findAll();
	}
	
	//Read one by ID
	public Hero readHeroById(Integer id) {
		Optional<Hero> foundHero = repo.findById((int)id);
		return foundHero.get();
	}
	
	//Update one by ID
	public Hero updateHero(Integer id, Hero newHero) {
		Hero foundHero = repo.findById((int)id).get();
		foundHero.setName(newHero.getName());
		foundHero.setPowerLevel(newHero.getPowerLevel());
		foundHero.setPowers(newHero.getPowers());
		foundHero.setTragicBackstory(newHero.getTragicBackstory());
		Hero updatedHero = repo.save(foundHero);
		return updatedHero;
	}
	
	//Delete one by ID
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
