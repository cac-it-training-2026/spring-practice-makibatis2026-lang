package jp.co.sss.practice.p04.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class Practice0402Controller {

	@RequestMapping(path = "/numguess/start", method = RequestMethod.GET)
	public String start(HttpSession session) {
		
		Integer hitNumber = (int) (Math.floor(Math.random() * 9) + 1);
		session.setAttribute("hitNum", hitNumber);
		System.out.println("hitNum:" + hitNumber);
		
		return "practice04/02/numguess_start";
	}
	
	@RequestMapping(path = "/numguess/input", method = RequestMethod.GET)
	public String input() {
		return "practice04/02/numguess_input";
	}
	
	@RequestMapping(path = "/numguess/judge", method = RequestMethod.GET)
	public String judge(HttpSession session,Integer inputNum) {
		Integer hitNum = (Integer) session.getAttribute("hitNum");
		
		if (hitNum == inputNum) {
			return "redirect:/numguess/hit";
		} else {
			return "practice04/02/numguess_judge";
		}
	}
	
	@RequestMapping(path = "/numguess/hit", method = RequestMethod.GET)
	public String third(Model model,HttpSession session) {
		
		Integer hitNum = (Integer) session.getAttribute("hitNum");
		String message = "当たりです！ 正解は" + hitNum + "でした。";
		model.addAttribute("message", message);
		session.removeAttribute("hitNum");
		
		return "practice04/02/numguess_end";
	}
}
