package com.iamcujo.togleShop.order.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iamcujo.togleShop.order.model.togleDAO;
import com.iamcujo.togleShop.support.CommonComponent;

@Service("togleService")
public class togleServiceImpl extends CommonComponent implements togleService {

	public togleServiceImpl() throws Exception {
		super();
	}
	
	@Resource(name="togleDAO")
    private togleDAO togledao;
	
	//결제번호로 계산된 결제 내역을 조회
	@Override
	public List<Map<String, Object>> selectOrderList(Map<String, Object> map) throws Exception {
		return togledao.selectOrderList(map); 
	}
	
	//결제하는 상품의 상품코드 조회
	@Override
	public int selectGoodsInfo(Object object) throws Exception {
		return togledao.selectGoodsInfo(object);
	}
	
	//결제번호로 계산된 결제 내역을 삭제
	@Override
	public void deleteOrder(ArrayList<Map<String,Object>> list) throws Exception,SQLException {
		try {
			SqlMap.startTransaction();
			togledao.deleteOrder(list);
			SqlMap.commitTransaction();
		} catch (SQLException se) {

		} catch (Exception e) {

		} finally {
			SqlMap.endTransaction();
		}
	}
	
	//결제번호로 결제 완료 처리
	@Override
	public void updateOrderConfirm(ArrayList<Map<String,Object>> list) throws Exception,SQLException {
		try {
			SqlMap.startTransaction();
			togledao.updateOrderConfirm(list);
			SqlMap.commitTransaction();
		} catch (SQLException se) {

		} catch (Exception e) {

		} finally {
			SqlMap.endTransaction();
		}
	}

}
