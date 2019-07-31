package com.sivadas.anand.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivadas.anand.enity.User;
import com.sivadas.anand.repository.UserSearch;

@Controller
@Transactional
public class SearchViewController {

	protected static final Logger LOGGER = LoggerFactory.getLogger(SearchViewController.class);

	@Autowired
	private UserSearch userSearch;

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "Try to go here: " + "<a href='/search?q=hola'>/search?q=hola</a>";
	}

	/**
	 * Show search results for the given query.
	 *
	 * @param q The search query.
	 */
	@RequestMapping("/search")
	public String search(final String q, final Model model) {
		List<User> searchResults = null;
		try {
			searchResults = userSearch.search(q);
		} catch (final Exception ex) {
			LOGGER.error("eception = {}", ex);
		}
		model.addAttribute("searchResults", searchResults);
		return "search";
	}

}
