package com.iamcujo.togleShop.order.model;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.iamcujo.togleShop.support.CommonComponent;

@Repository("togleDAO")
public class togleDAO extends CommonComponent {

	public togleDAO() throws Exception {
		super();
	}
	
	//결제번호로 계산된 결제 내역을 조회
	@SuppressWarnings("unchecked") 
	public List<Map<String, Object>> selectOrderList(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)SqlMap.queryForList("com.iamcujo.togleShop.order.sql.togleSqlMap.selectOrderList", map);
	}
	
	//결제번호로 계산된 결제 내역을 삭제
	public void deleteOrder(List<Map<String,Object>> list) throws Exception{
		SqlMap.delete("com.iamcujo.togleShop.order.sql.togleSqlMap.deleteOrder", list);
	}
	
	//결제번호로 결제 완료 처리
	public void updateOrderConfirm(List<Map<String,Object>> list) throws Exception{
		SqlMap.update("com.iamcujo.togleShop.order.sql.togleSqlMap.updateOrderConfirm", list);
	}

}
