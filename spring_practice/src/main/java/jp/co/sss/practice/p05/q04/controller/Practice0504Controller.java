package jp.co.sss.practice.p05.q04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0504Controller {

	@Autowired
	FruitsSeasonRepository fruitRepository;

	@RequestMapping("/fruits/search/input")
	public String showSearchFruitsBySeason() {
		return "practice05/04/fruits_select_season";
	}
	
	@RequestMapping("/fruits/search/result")
	public String searchFruitsBySeason(Integer season,Model model) {
		model.addAttribute("fruitsList", fruitRepository.findBySeasonMonthOrderByFruitId(season));
		String searchSeason="<"+season+"月>";
		if(season==13) {
			searchSeason="<通年>";
		}
		model.addAttribute("searchSeason", searchSeason);
		return "practice05/04/fruits_list";
	}

}
