package com.iamcujo.togleShop.order.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iamcujo.togleShop.order.service.togleService;
import com.iamcujo.togleShop.support.CommonComponent;

@Controller
public class togleorder extends CommonComponent {

	public togleorder() throws Exception {
		super();
	}
	
	@Resource(name="togleService")
    private togleService togleservice;
	
	/* 결제번호로 계산된 결제 내역을 조회 */
	@RequestMapping(value = "search.do", method = RequestMethod.POST)
	public ModelAndView search( HttpServletRequest request
			                  , HttpServletResponse response
			                  , Map<String,Object> commandMap
			                  , @RequestParam(value="order_no"       , required=false, defaultValue=""    ) String order_no        //주문번호
			                  , @RequestParam(value="pay_no"         , required=false, defaultValue=""    ) String pay_no          //결제번호
			                  , @RequestParam(value="order_nm"       , required=false, defaultValue=""    ) String order_nm        //주문자 이름
			                  , @RequestParam(value="order_tel"      , required=false, defaultValue=""    ) String order_tel       //주문자 연락처
			                  , @RequestParam(value="order_id"       , required=false, defaultValue=""    ) String order_id        //주문자 ID
			                  , @RequestParam(value="order_goods"    , required=false, defaultValue=""    ) String order_goods     //주문 상품
			                  , @RequestParam(value="order_qty"      , required=false, defaultValue=""    ) String order_qty       //주문 수량
			                  , @RequestParam(value="recv_nm"        , required=false, defaultValue=""    ) String recv_nm         //수취인 이름
			                  , @RequestParam(value="recv_tel1"      , required=false, defaultValue=""    ) String recv_tel1       //수취인 연락처1
			                  , @RequestParam(value="recv_tel2"      , required=false, defaultValue=""    ) String recv_tel2       //수취인 연락처2
			                  , @RequestParam(value="recv_zip"       , required=false, defaultValue=""    ) String recv_zip        //수취인 우편번호
			                  , @RequestParam(value="recv_address1"  , required=false, defaultValue=""    ) String recv_address1   //수취인 주소
			                  , @RequestParam(value="recv_address2"  , required=false, defaultValue=""    ) String recv_address2   //수취인 상세주소
			                  , @RequestParam(value="delivery_remark", required=false, defaultValue=""    ) String delivery_remark //배송 메시지
			                  ) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		/* 파라미터 맵핑 */
		commandMap.put("orderNo", order_no);
		commandMap.put("payNo", pay_no);
		commandMap.put("orderNm", order_nm);
		commandMap.put("orderTel", order_tel);
		commandMap.put("orderId", order_id);
		commandMap.put("orderGoods", order_goods);
		commandMap.put("orderQty", order_qty);
		commandMap.put("recvNm", recv_nm);
		commandMap.put("recvTel1", recv_tel1);
		commandMap.put("recvTel2", recv_tel2);
		commandMap.put("recvZip", recv_zip);
		commandMap.put("recvAddress1", recv_address1);
		commandMap.put("recvAddress2", recv_address2);
		commandMap.put("deleveryRemark", delivery_remark);
		
		List<Map<String,Object>> orderList = togleservice.selectOrderList(commandMap);
		
		mav.addObject("orderList", orderList);
		
		return mav;
	}
	
	/* 결제번호로 계산된 결제 내역을 삭제 */
	@RequestMapping(value = "remove.do", method = RequestMethod.POST)
	public ModelAndView delete( HttpServletRequest request
			                  , HttpServletResponse response
			                  , Map<String,Object> commandMap
			                  , @RequestParam(value="pay_no"         , required=true) String pay_no
                              ) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		String chkFg = "";
		
		ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		commandMap.put("payno", pay_no);
		list.add(commandMap);
		
		togleservice.deleteOrder(list);
		
		//성공 시 flag (message 출력용)
		chkFg = "remove";
		mav.addObject("chkFg", chkFg);
		
		return mav;
	}
	
	/* 결제번호로 결제 완료 처리 */
	@RequestMapping(value = "confirm.do", method = RequestMethod.POST)
	public ModelAndView confirm( HttpServletRequest request
                               , HttpServletResponse response
			                   , Map<String,Object> commandMap
			                   , @RequestParam(value="pay_no"       , required=true) String pay_no
			                   ) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		String chkFg = "";
		
		ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		commandMap.put("payno", pay_no);
		list.add(commandMap);
		
		togleservice.updateOrderConfirm(list);
		
		//성공 시 flag (message 출력용)
		chkFg = "confirm";
		mav.addObject("chkFg", chkFg);
		
		return mav;
	}

}
