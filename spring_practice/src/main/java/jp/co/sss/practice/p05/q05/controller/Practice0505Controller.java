package jp.co.sss.practice.p05.q05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.form.FruitsSeasonForm;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0505Controller {

	@Autowired
	FruitsSeasonRepository fruitRepository;

//	入力画面表示用
	@RequestMapping("/fruits/add/input")
	public String input() {
		return "practice05/05/fruit_input";
	}
	
//	登録受付、登録処理、登録完了画面表示用
	@RequestMapping(path = "/fruits/add/complete", method = RequestMethod.POST)
	public String complete(FruitsSeasonForm fruitForm , Model model) {
//		FruitsSeasonエンティティの生成
		FruitsSeason fruit = new FruitsSeason();
		
//		FruitsSeasonエンティティに入力された値(FruitsSeasonFormの内容)をコピー
		fruit.setFruitId(fruitForm.getFruitId());
		fruit.setFruitName(fruitForm.getFruitName());
		fruit.setSeasonMonth(fruitForm.getSeasonMonth());
		
//		FruitsSeasonRepository を利用してfruits_season テーブルに登録
		fruit = fruitRepository.save(fruit);
		
//		JavaBeanのオブジェクトを生成
		FruitsSeasonBean fruitsBean = new FruitsSeasonBean();
		
//		登録結果(FruitsSeasonエンティティ)をJavaBeanのオブジェクトにコピー
		fruitsBean.setFruitId(fruit.getFruitId());
		fruitsBean.setFruitName(fruit.getFruitName());
		fruitsBean.setSeasonMonth(fruit.getSeasonMonth());
		
//		JavaBeanのオブジェクトをリクエストスコープに保存
		model.addAttribute("fruit", fruitsBean);
		
		return "practice05/05/fruit_detail";
	}
}
