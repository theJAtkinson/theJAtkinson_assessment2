package com.qa.hss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hss.domain.Hero;
import com.qa.hss.service.HeroService;

@RestController
@CrossOrigin
public class HeroController {

	private HeroService service;

	@Autowired
	public HeroController(HeroService service) {
		super();
		this.service = service;
	}

	// CRUD FUNCTIONALITY

	// Create
	// Should return 201 'created' on success
	@PostMapping("/create")
	public ResponseEntity<Hero> createHero(@RequestBody Hero hero) {
		Hero createdHero = service.createHero(hero);
		return new ResponseEntity<Hero>(createdHero, HttpStatus.CREATED);
	}

	// Read all
	// Should return 200 'okay' on success
	@GetMapping("/read/all")
	public ResponseEntity<List<Hero>> readAllHero() {
		return ResponseEntity.ok(service.readAllHero());
	}

	// Read one by ID
	// Should return 200 'okay' on success
	// As 200 is default response, we don't need to return a ResponseEntity
	@GetMapping("/read/id/{id}")
	public Hero readHeroById(@PathVariable Integer id) {
		return service.readHeroById(id);
	}

	// Update
	// Shoulder return 202 'accepted' on success
	@PutMapping("update/id/{id}")
	public ResponseEntity<Hero> updateHeroById(@PathVariable Integer id,@RequestBody Hero newHero){
		Hero updatedHero = service.updateHero(id, newHero);
		return new ResponseEntity<Hero>(updatedHero, HttpStatus.ACCEPTED);
	}
	
	// Delete
	// Should return 204 'no content' on success
	@DeleteMapping("delete/id/{id}")
	public ResponseEntity<?> deleteHeroById(@PathVariable Integer id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
