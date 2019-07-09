package application;

import java.util.Date;
import java.util.List;
import model.dao.DAO_Factory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDAO sellerDAO = DAO_Factory.createSellerDAO();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDAO.findByID(1);
		System.out.println(seller);
		
		System.out.println("=== TEST 2: seller findByDepartment ===");
		List<Seller> list = sellerDAO.findByDepartment(new Department(1, ""));
        list.forEach(System.out::println);
        
		System.out.println("=== TEST 3: seller findAll ===");
		list = sellerDAO.findAll();
        list.forEach(System.out::println);
        
    	System.out.println("=== TEST 3: seller insert ===");
    	Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, new Department(1, ""));
		sellerDAO.insert(newSeller);
        System.out.println("Inserted! New id: " + newSeller.getId());
	}
}














