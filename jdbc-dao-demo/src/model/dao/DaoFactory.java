package model.dao;

import Db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.loadConnection());
	} 
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.loadConnection());
	}
}
