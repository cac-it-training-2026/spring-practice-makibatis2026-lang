package jp.co.sss.practice.p06.q02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.practice.p06.entity.Area;
import jp.co.sss.practice.p06.repository.AreaRepository;
import jp.co.sss.practice.p06.repository.FruitsAreaRepository;

@Controller
public class Practice0602Controller {

	@Autowired
	FruitsAreaRepository fruitsRepository;
	
	@Autowired
	AreaRepository areaRepository;
	
//	種別選択画面表示用
	@RequestMapping("/fruits/select/area")
	public String selectArea(Model model) {
//		地域一覧を地域ID昇順で取得し、リクエストスコープに保存
		model.addAttribute("area", areaRepository.findAllByOrderByAreaId());
		return "practice06/02/area_select";
	}
	
//	検索処理、結果表示用
	@RequestMapping("/fruits/select/area/result")
	public String areaResult(Integer areaId, Model model) {
//		入力された値を受け取り、地域情報をareaテーブルより取得
		Area area = areaRepository.getReferenceById(areaId);
//		地域情報から地域名をリクエストスコープに保存
		model.addAttribute("area", area);
//		地域情報を利用してfruits_areaテーブルより該当する地域のフルーツ情報を取得
//		検索結果(フルーツ情報一覧)をリクエストスコープに保存
		model.addAttribute("fruits", fruitsRepository.findByAreaOrderByFruitId(area));
		return "practice06/02/fruits_list";
	}
}
