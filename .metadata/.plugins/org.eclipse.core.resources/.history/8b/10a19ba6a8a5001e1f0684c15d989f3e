package program;

import model.dao.DaoFactory;
import model.dao.SellerDao;

public class Program {
	
	public static void main(String[] args) {
	
		DaoFactory daoFactory = new DaoFactory();
		
		SellerDao  sellerDao = daoFactory.createSellerDao();
		
		System.out.println(sellerDao.findById(1));
	}
}
