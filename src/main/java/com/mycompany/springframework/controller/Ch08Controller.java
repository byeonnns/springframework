package com.mycompany.springframework.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.mycompany.springframework.dto.Ch08CartItem;
import com.mycompany.springframework.dto.Ch08Product;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ch08")
public class Ch08Controller {
   
   /**
    * 상품 목록 
    * @return
    */
   @RequestMapping("/productList")
   public String productList(Model model) {
      // 상품 데이터 생성
      List<Ch08Product> productList = new ArrayList<Ch08Product>();
      for (int i = 1; i <= 5; i ++) {
         productList.add(new Ch08Product(i, "상품" + i, i * 10000));
      }
      
      // request 범위에 저장
      model.addAttribute("productList", productList);
      model.addAttribute("chNum", "ch08");
      
      return "ch08/productList";
   }
   
   /**
    * 장바구니 상품 상세 조회
    * @return
    */
   @RequestMapping("/detailView")
   public String detailView(int pno, Model model) {
      // 상품 상세 정보 얻기
      // 아직 db가 없는 상황이라, 임의로 pno에 해당하는 상품 객체를 생성함 
       Ch08Product product = new Ch08Product(pno, "상품" + pno, pno * 10000);
      
       // request 범위에 저장
       model.addAttribute("product", product);
       model.addAttribute("chNum", "ch08");
       
      return "ch08/detailView";
   }
   
   /**
    *  장바구니 상품 전체 조회
    * @return ch08/cartView 
    */
   @RequestMapping("/cartView")
   public String cartView(HttpSession session) {
      // 장바구니를 세션에서 가져오기
       List<Ch08CartItem> cart = (List<Ch08CartItem>) session.getAttribute("cart");
       if(cart == null) {
          // (처음 실행시) 세션에서 가져온 장바구니가 없을 경우 (null),
          // 새로 장바구니를 생성해서 session 범위에 저장
          cart = new ArrayList<Ch08CartItem>();
          session.setAttribute("cart", cart);
       } 
      
      return "ch08/cartView";
   }
   
   /**
    *  장바구니 상품 추가
    * @return redirect:/ch08/cartView
    */
   @RequestMapping("/addCartItem")
   public String addCartItem(int pno, int amount, HttpSession session) {
      log.info("pno: " + pno);
      log.info("amount: " + amount);
      
       
       // 장바구니를 세션에서 가져오기
       List<Ch08CartItem> cart = (List<Ch08CartItem>) session.getAttribute("cart");
       if(cart == null) {
          // (처음 실행시) 세션에서 가져온 장바구니가 없을 경우 (null),
          // 새로 장바구니를 생성해서 session 범위에 저장
          cart = new ArrayList<Ch08CartItem>();
          session.setAttribute("cart", cart);
       }
       
       boolean isAmountUpdated = false;
       for (Ch08CartItem cartItem : cart) {
    	   if ( cartItem.getProduct().getPno() == pno ) {
    		   cartItem.setAmount(cartItem.getAmount() + amount);
    		   isAmountUpdated = true;
    	   }
       }
       
       // amount가 업데이트되지 않았다면 false를 유지 -> 그럼 새 상품으로 장바구니에 추가
       if (!isAmountUpdated) {
    	   // 상품 상세 정보 얻기
    	   // 아직 db가 없는 상황이라, 임의로 pno에 해당하는 상품 객체를 생성함 
    	   Ch08Product product = new Ch08Product(pno, "상품" + pno, pno * 10000);
    	   
    	   // 장바구니 아이템 생성
    	   Ch08CartItem cartItem = new Ch08CartItem();
    	   cartItem.setProduct(product);
    	   cartItem.setAmount(amount);
    	   
    	   // 장바구니에 장바구니 아이템을 추가
    	   cart.add(cartItem);
       }
    	   
       
      return "redirect:/ch08/cartView";
   }
   
   
   /**
    * 장바구니 상품 수량 업데이트 
    * @return
    */
   @RequestMapping(value="/updateCartItem", produces="application/json; charset=UTF-8")
   @ResponseBody
	public String updateCartItem(int pno, int amount, @SessionAttribute List<Ch08CartItem> cart) {
	   
	   // pno와 같은 CartItem 찾기
	   for (Ch08CartItem item : cart) {
		   if (item.getProduct().getPno() == pno) {
			   // CartItem의 amount를 수정
			   item.setAmount(amount);
		   }
	   }
	   
	   // 수정 결과를 응답으로 생성
	   JSONObject jsonObject = new JSONObject();
	   jsonObject.put("result", "success");
	   
	   return jsonObject.toString();
   }
   
   /**
    * 장바구니 상품 삭제
    * @return
    */
   @RequestMapping("/removeCartItem")
   public String removeCartItem(int pno, @SessionAttribute List<Ch08CartItem> cart) {
	   
	   // pno와 같은 CartItem 찾기
	   Iterator<Ch08CartItem> iterator = cart.iterator();
	   
	   // iterator가 가져올 게 없을 때까지 반복
	   while (iterator.hasNext()) {
		   Ch08CartItem cartItem = iterator.next();
		   
		   if ( cartItem.getProduct().getPno() == pno ) {
			   iterator.remove();
		   }
	   }
	   
	   return "redirect:/ch08/cartView";
   }

}