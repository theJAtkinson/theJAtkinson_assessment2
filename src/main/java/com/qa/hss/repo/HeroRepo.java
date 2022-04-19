package com.qa.hss.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hss.domain.Hero;

@Repository
public interface HeroRepo extends JpaRepository<Hero, Integer> {

}
