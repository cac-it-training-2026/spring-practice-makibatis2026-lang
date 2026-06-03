package jp.co.sss.practice.p05.q06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.form.FruitsSeasonForm;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0506Controller {
	
	@Autowired
	FruitsSeasonRepository repository;

//	フルーツ名選択画面表示用
	@RequestMapping("/fruits/update")
	public String update(Model model) {
//		フルーツ情報一覧をデータベースから取得し、リクエストスコープに保存
		model.addAttribute("fruits", repository.findAllByOrderByFruitId());
		return "practice05/06/fruit_select";
	}
	
//	入力画面表示用
	@RequestMapping(path = "/fruits/update/input", method = RequestMethod.POST)
	public String input(Integer fruitId , Model model) {
//		パラメータとして受け取ったフルーツIDを利用して主キー検索を行う
		FruitsSeason fruit =repository.getReferenceById(fruitId);
//		JavaBeanのオブジェクトを生成
		FruitsSeasonBean fruitBean = new FruitsSeasonBean(); 
//		検索結果(FruitsSeasonエンティティ)の内容をJavaBeanにコピー
		fruitBean.setFruitId(fruit.getFruitId());
		fruitBean.setFruitName(fruit.getFruitName());
		fruitBean.setSeasonMonth(fruit.getSeasonMonth());
//		JavaBeanをリクエストスコープに保存
		model.addAttribute("fruit", fruitBean);
		return "practice05/06/fruit_input";
	}
	
//	更新受付、更新処理、更新完了画面表示用
	@RequestMapping(path = "/fruits/update/complete/{fruitId}", method = RequestMethod.POST)
	public String complete(@PathVariable Integer fruitId , FruitsSeasonForm fruitForm , Model model) {
//		FruitsSeasonエンティティの生成
		FruitsSeason fruit = repository.getReferenceById(fruitId);
//		FruitsSeasonエンティティに入力された値(FruitsSeasonFormの内容)をコピー 
		fruit.setFruitName(fruitForm.getFruitName());
		fruit.setSeasonMonth(fruitForm.getSeasonMonth());
//		FruitsSeasonRepository を利用してテーブルの該当レコードを更新
		fruit = repository.save(fruit);
//		JavaBeanのオブジェクトを生成
		FruitsSeasonBean fruitBean = new FruitsSeasonBean();
//		更新結果(FruitsSeasonエンティティ)をJavaBeanのオブジェクトにコピー
		fruitBean.setFruitId(fruit.getFruitId());
		fruitBean.setFruitName(fruit.getFruitName());
		fruitBean.setSeasonMonth(fruit.getSeasonMonth());
//		JavaBeanのオブジェクトをリクエストスコープに保存
		model.addAttribute("fruit", fruitBean);
		return "practice05/06/fruit_detail";
	}

}
