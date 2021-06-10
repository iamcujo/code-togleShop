package com.iamcujo.togleShop.order.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

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
	
	//결제번호로 계산된 결제 내역을 삭제
	@Override
	public void deleteOrder(ArrayList<Map<String,Object>> list) throws Exception,SQLException {
		try {
			SqlMap.startTransaction();
			togleDAO.deleteOrder(list);
			SqlMap.commitTransaction();
		} catch (SQLException se) {
			log.write(se.toString());
			throw new WebAppException();
		} catch (Exception e) {
			log.write(e.toString());
			throw new WebAppException();
		} finally {
			SqlMap.endTransaction();
		}
	}
	
	//결제번호로 결제 완료 처리
	@Override
	public void updateOrderConfirm(ArrayList<Map<String,Object>> list) throws Exception,SQLException {
		try {
			SqlMap.startTransaction();
			togleDAO.updateOrderConfirm(list);
			SqlMap.commitTransaction();
		} catch (SQLException se) {
			log.write(se.toString());
			throw new WebAppException();
		} catch (Exception e) {
			log.write(e.toString());
			throw new WebAppException();
		} finally {
			SqlMap.endTransaction();
		}
	}

}
