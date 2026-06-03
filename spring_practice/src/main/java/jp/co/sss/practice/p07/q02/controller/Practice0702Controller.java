package jp.co.sss.practice.p07.q02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jp.co.sss.practice.p07.entity.Type;
import jp.co.sss.practice.p07.repository.TypeRepository;

@Controller
public class Practice0702Controller {

	@Autowired
	TypeRepository typeRepository;
	
	@Autowired
	EntityManager entityManager;
	
//	検索条件入力画面表示用
	@RequestMapping("/fruits_shop/named/input")
	public String namedInput(Model model) {
//		種別一覧を取得し、リクエストスコープに保存
		model.addAttribute("types", typeRepository.findAll());
		return "practice07/02/search_input";
	}
	
//	表示情報の取得、結果表示用
	@RequestMapping("/fruits_shop/named/result")
	public String namedResult(Integer minPrice, Integer maxPrice, Integer typeId , Model model) {
//		Typeエンティティのオブジェクトを生成し、入力されたtypeIdをセット
		Type type = new Type();
		type.setTypeId(typeId);
//		エンティティマネージャを利用してQueryオブジェクトを生成
		Query query = entityManager.createNamedQuery("findNamedQueryByPriceRangeAndType");
//		Typeエンティティのオブジェクトの値をJPQLのパラメータにセット
		query.setParameter("type",type);
//		入力された値minPriceをJPQLのパラメータにセット
		query.setParameter("min",minPrice);
//		入力された値maxPriceをJPQLのパラメータにセット
		query.setParameter("max",maxPrice);
//		JPQLを実行し、検索結果を取得し、リクエストスコープに保存
		model.addAttribute("items",query.getResultList());
		return "practice07/02/items_list";
	}
}
