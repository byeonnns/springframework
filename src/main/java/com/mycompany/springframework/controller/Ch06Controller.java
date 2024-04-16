package com.mycompany.springframework.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springframework.dto.Ch06Cart;
import com.mycompany.springframework.dto.Ch06Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch06")
public class Ch06Controller {
	@GetMapping("/forward")
	public String forward(Model model, HttpServletRequest request) {
		log.info("실행");
		model.addAttribute("chNum", "ch06");
		
		// 데이터 생성
		Ch06Member member = new Ch06Member();
		member.setMid("spring");
		member.setMname("김벚꽃");
		member.setMemail("kim@naver.com");
		
		// request 범위에 객체 저장 (forward할 때까지 계속 사용할 수 있는 범위)
		// 응답이 전송되면 request 범위에서 사용한 데이터는 사라짐 -> HttpServletRequest 객체에 데이터가 저장되는데 요청마다 생성되고 사라지기 때문
		model.addAttribute("member1", member);
		request.setAttribute("member2", member);
		
		return "ch06/forward";
	}
	
	@GetMapping("/redirect")
	public String redirect(HttpSession session) {
		log.info("실행");
		
		// 데이터 생성
		List<String> items = new ArrayList<>();
		items.add("상품1");
		items.add("상품2");
		items.add("상품3");
		
		Ch06Cart cart = new Ch06Cart();
		cart.setItems(items);
		
		// session 범위에 객체를 저장
		// 동일한 클라이언트(브라우저)가 사용할 수 있는 범위
		
		session.setAttribute("cart", cart);
		
		
		return "redirect:/ch06/sessionData";
	}
	
	@GetMapping("/sessionData")
	public String sessionData(HttpSession session, Model model) {
		log.info("실행");
		model.addAttribute("chNum", "ch06");
		
		// session 범위에 저장된 객체 가져오기
		// 리턴하는 객체의 타입이 Object이므로 강제 타입 변환을 해줌
		Ch06Cart cart = (Ch06Cart) session.getAttribute("cart");
		
		if ( cart != null ) {
			for (String item : cart.getItems()) {
				log.info(item);
			}
		}
		
		return "ch06/sessionData";
	}
}
