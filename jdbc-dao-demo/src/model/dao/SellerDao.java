package model.dao;

import java.util.List;

import model.Entities.Department;
import model.Entities.Seller;

public interface SellerDao {

	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findByDepartment(Department department);
	List<Seller> findAll();

}
