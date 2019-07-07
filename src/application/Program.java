package application;

import java.util.Date;
import model.dao.DAO_Factory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDAO sellerDAO = DAO_Factory.createSellerDAO();
		
		Seller seller = sellerDAO.findByID(3);
		
		System.out.println(seller);
		
	}
}














