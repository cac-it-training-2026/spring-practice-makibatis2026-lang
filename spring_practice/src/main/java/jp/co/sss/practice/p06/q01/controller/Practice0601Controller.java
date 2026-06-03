package jp.co.sss.practice.p06.q01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.practice.p06.repository.FruitsAreaRepository;

@Controller
public class Practice0601Controller {

	@Autowired
	FruitsAreaRepository fruitAreaRepository;
	
	//全件検索結果表示
	@RequestMapping("/fruits/area/list/all")
	public String listAll(Model model) {
//		fruits_areaテーブルの全レコードを取得し、リクエストスコープに保存
		model.addAttribute("fruits", fruitAreaRepository.findAll());
		return "practice06/01/fruits_list";
	}
}
