package program;

import model.Entities.Department;
import model.Entities.Seller;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;

public class Program2 {
	public static void main(String[] args) {
		
		DaoFactory daoFactory = new DaoFactory();
		
		DepartmentDao departmentDao = daoFactory.createDepartmentDao();
		
		
		System.out.println("===TESTE 1: findById===");
		System.out.println(departmentDao.findById(1));
		System.out.println();
		
		System.out.println("===TESTE 2: findAll===");
		for (Department department : departmentDao.findAll()) {
			System.out.println(department);
		}
		System.out.println();

	}

}
