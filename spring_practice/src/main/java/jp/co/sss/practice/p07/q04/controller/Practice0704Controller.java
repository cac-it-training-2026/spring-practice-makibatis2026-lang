package jp.co.sss.practice.p07.q04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.practice.p07.repository.FruitsShopItemRepository;

@Controller
public class Practice0704Controller {

	@Autowired
	FruitsShopItemRepository fruitsShopItemRepository;
	
//	種別一覧表示
	@RequestMapping("/fruits_shop/type/sort/bycount")
	public String queryInput(Model model) {
//		属する食料品数順に並び変えられた種別一覧を取得し、リクエストスコープに保存
		model.addAttribute("types", fruitsShopItemRepository.findQuerySortByTypeCount());
		return "practice07/04/type_list";
	}
}
