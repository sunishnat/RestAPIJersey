package com.restapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.restapi.Employee;
import com.restapi.connection.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	public List<Employee> getEmployees() {

		String query = "select * from employee";
		List<Employee> employees = new ArrayList<Employee>();
		
		Connection con = DBConnection.getMySQLConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				Employee emp = new Employee();
				emp.setEid(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setTech(rs.getString(3));
				employees.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return employees;
	}

	public Employee getEmployeebyId(int id) {

		String query = "select * from employee where eid = ?";
		Employee emp = new Employee();
		
		Connection con = DBConnection.getMySQLConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				emp.setEid(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setTech(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	public void addEmployee(Employee emp) {

		String query = "insert into employee values(?,?,?)";
		
		Connection con = DBConnection.getMySQLConnection();
		PreparedStatement pst = null;
		
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, emp.getEid());
			pst.setString(2, emp.getEname());
			pst.setString(3, emp.getTech());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateEmployee(Employee emp) {

		String query = "update employee set ename = ?, tech = ? where eid = ?";
		
		Connection con = DBConnection.getMySQLConnection();
		PreparedStatement pst = null;
		
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, emp.getEname());
			pst.setString(2, emp.getTech());
			pst.setInt(3, emp.getEid());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteEmployee(int id) {

		String query = "delete from employee where eid = ?";
		
		Connection con = DBConnection.getMySQLConnection();
		PreparedStatement pst = null;
		
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
