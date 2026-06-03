package jp.co.sss.practice.p07.q03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.practice.p07.entity.Type;
import jp.co.sss.practice.p07.repository.FruitsShopItemRepository;
import jp.co.sss.practice.p07.repository.TypeRepository;

@Controller
public class Practice0703Controller {

	@Autowired
	FruitsShopItemRepository fruitsShopItemRepository;
	
	@Autowired
	TypeRepository typeRepository;
	
//	検索条件入力画面表示用
	@RequestMapping("/fruits_shop/query/input")
	public String queryInput(Model model) {
//		種別一覧を取得し、リクエストスコープに保存
		model.addAttribute("types", typeRepository.findAll());
		return "practice07/03/search_input";
	}
	
//	表示情報の取得、結果表示用
	@RequestMapping("/fruits_shop/query/result")
	public String namedResult(Integer minPrice, Integer maxPrice, Integer typeId , Model model) {
//		Typeエンティティのオブジェクトを生成し、入力されたtypeIdをセット
		Type type = new Type();
		type.setTypeId(typeId);
		
//		検索結果をリクエストスコープに保存
		model.addAttribute("items",fruitsShopItemRepository.findQueryByPriceRangeAndType(minPrice, maxPrice, type));
		return "practice07/03/items_list";
	}
}
