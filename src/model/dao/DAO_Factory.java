package model.dao;

import db.DB;
import model.dao.impl.SellerDAO_jdbc;

public class DAO_Factory {
	
	public static SellerDAO createSellerDAO() {
		return new SellerDAO_jdbc(DB.getConnection());
	}

}
