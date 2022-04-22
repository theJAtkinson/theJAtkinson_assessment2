package com.qa.hss.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hss.domain.Hero;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:hero-schema.sql",
		"classpath:hero-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class HeroControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	// CRUD TESTS

	// Create
	@Test
	public void testCreateHero() throws Exception {
		Hero testHeroInput = new Hero(null, "Hero Name", 9999, "Hero Powers", "Hero Tragic Backstory");
		String testHeroInputAsJSON = mapper.writeValueAsString(testHeroInput);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testHeroInputAsJSON);

		Hero testHeroOutput = new Hero(4, "Hero Name", 9999, "Hero Powers", "Hero Tragic Backstory");
		String testHeroOutputAsJSON = mapper.writeValueAsString(testHeroOutput);

		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testHeroOutputAsJSON);

		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	// Read all
	@Test
	public void testReadAllHero() throws Exception {
		RequestBuilder req = get("/read/all");

		List<Hero> testListOutput = List.of(
				new Hero(1, "Batman", 10, "He is just rich and smart", "parents died in a robbery gone wrong"),
				new Hero(2, "John Smith", 0, "None", "Stubbed toe this morning"),
				new Hero(3, "Cool-Awesome-man", 10000, "Super speed, super strength, can control time",
						"Entire family died in tragic blimp accident"));
		String testListOutputAsJSON = mapper.writeValueAsString(testListOutput);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testListOutputAsJSON);

		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	// Read one by ID
	@Test
	public void testReadHeroById() throws Exception {
		RequestBuilder req = get("/read/id/2");

		Hero testHeroOutput = new Hero(2, "John Smith", 0, "None", "Stubbed toe this morning");
		String testHeroOutputAsJSON = mapper.writeValueAsString(testHeroOutput);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testHeroOutputAsJSON);

		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	// Update one by ID
	@Test
	public void testUpdateHeroById() throws Exception {
		Hero testHeroInput = new Hero(null, "Hero Name", 9999, "Hero Powers", "Hero Tragic Backstory");
		String testHeroInputAsJSON = mapper.writeValueAsString(testHeroInput);
		RequestBuilder req = put("/update/id/1").contentType(MediaType.APPLICATION_JSON).content(testHeroInputAsJSON);

		Hero testHeroOutput = new Hero(1, "Hero Name", 9999, "Hero Powers", "Hero Tragic Backstory");
		String testHeroOutputAsJSON = mapper.writeValueAsString(testHeroOutput);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testHeroOutputAsJSON);

		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	// Delete one by ID
	@Test
	public void testDeleteHeroById() throws Exception {
		RequestBuilder req = delete("/delete/id/2");

		ResultMatcher checkStatus = status().isNoContent();

		mvc.perform(req).andExpect(checkStatus);
	}
}
