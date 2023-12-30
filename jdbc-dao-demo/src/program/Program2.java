package program;

import java.util.Date;
import java.util.Scanner;

import model.Entities.Department;
import model.Entities.Seller;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;

public class Program2 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
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

		System.out.println("===TESTE 3: Insert===");
		Department department = new Department(null, "Games");
		departmentDao.insert(department);
		System.out.println("Id : " + department.getId());
		System.out.println();

		System.out.println("===TESTE 4: Update===");
		department = departmentDao.findById(1);
		department.setName("DVD");
		departmentDao.update(department);
		System.out.println("Update Completed! ");
		System.out.println(department);
		System.out.println();
		
		System.out.println("===TESTE 5: Delete===");
		int id = scan.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed!");
	}

}
