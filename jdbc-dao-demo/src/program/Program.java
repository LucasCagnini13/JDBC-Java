package program;

import model.dao.DaoFactory;
import model.dao.SellerDao;

import java.util.Date;

import model.Entities.Department;
import model.Entities.Seller;

public class Program {
	public static void main(String[] args) {
	
		DaoFactory daoFactory = new DaoFactory();
		
		SellerDao  sellerDao = daoFactory.createSellerDao();
		
		System.out.println("===TESTE 1: findById===");
		System.out.println(sellerDao.findById(1));
		System.out.println();
		
		System.out.println("===TESTE 2: findByDepartment===");
		Department department = new Department(2,"Electronics");
		for(Seller seller : sellerDao.findByDepartment(department)) {
			System.out.println(seller);
		}
		System.out.println();
		
		System.out.println("===TESTE 3: findAll===");
		for(Seller seller : sellerDao.findAll()) {
			System.out.println(seller);
		}
		System.out.println();
		
		System.out.println("===TESTE 4: Insert===");
		Seller seller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 1000.0, department);
		sellerDao.insert(seller);
		System.out.println("Id : "+seller.getId());
	}
}
