package com.iamcujo.togleShop.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface togleService {

	//결제번호로 계산된 결제 내역을 조회
	public abstract List<Map<String, Object>> selectOrderList(Map<String, Object> map) throws Exception;
	
	//결제번호로 계산된 결제 내역을 삭제
	public abstract void deleteOrder(ArrayList<Map<String,Object>> list) throws Exception;
	
	//결제번호로 결제 완료 처리
	public abstract void updateOrderConfirm(ArrayList<Map<String,Object>> list) throws Exception;
}
