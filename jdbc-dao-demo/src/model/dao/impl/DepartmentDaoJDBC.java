package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Db.DB;
import Db.DbExcepition;
import model.Entities.Department;
import model.dao.DepartmentDao;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {

		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		
	

	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {

	}

	@Override
	public Department findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"SELECT * from department "+ "WHERE department.Id = ?");

			st.setInt(1, id);

			rs = st.executeQuery();

			if (rs.next()) {
				
				Department department = new Department(rs.getInt(1), rs.getString(2));
				return department;
			}
			

		} catch (Exception e) {

			throw new DbExcepition(e.getMessage());
		} finally {

			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
		return null;
	}

	@Override
	public List<Department> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * from department " + "ORDER BY Name ");

			rs = st.executeQuery();

			List<Department> list = new ArrayList<>();

			while (rs.next()) {

				Department department = new Department(rs.getInt(1), rs.getString(2));
				list.add(department);
			}

			return list;

		} catch (SQLException e) {
			throw new DbExcepition(e.getMessage());

		} finally {

			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}
}
