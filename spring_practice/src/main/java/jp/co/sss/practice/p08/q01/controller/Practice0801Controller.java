package jp.co.sss.practice.p08.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import jp.co.sss.practice.p08.q01.form.BodyTempForm;

@Controller
public class Practice0801Controller {

//	入力画面表示用のメソッド
	@RequestMapping("/body_temp/input")
	public String input(@ModelAttribute BodyTempForm bodyTempForm) {
		return "practice08/01/bt_input";
	}
	
//	入力チェック処理用のメソッド 
	@RequestMapping(path = "/body_temp/check", method = RequestMethod.POST)
	public String check(@Valid @ModelAttribute BodyTempForm bodyTempForm, BindingResult result) {
		if (result.hasErrors()) { 
			return "practice08/01/bt_input";  
			}
		if (bodyTempForm.getBodyTemp() >= 35.0 && bodyTempForm.getBodyTemp() <= 37.5) { 
			     return "practice08/01/bt_ok"; 
			  } else { 
			return "practice08/01/bt_ng"; 
			 } 
	}
}
