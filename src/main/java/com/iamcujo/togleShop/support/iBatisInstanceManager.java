package com.iamcujo.togleShop.support;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class iBatisInstanceManager {

	private static SqlMapClient SqlMap;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			SqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}

public static SqlMapClient getInstance() {
	return SqlMap;
}

}
