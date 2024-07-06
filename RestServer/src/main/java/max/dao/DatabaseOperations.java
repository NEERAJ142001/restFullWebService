package max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import max.dto.CustomerDto;
import max.utils.JDBCUtility;

public class DatabaseOperations {

	public boolean userExistOrNot(String aadhar) {
		String query = "Select * from customer where aadhar=?";
		Connection con = JDBCUtility.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, aadhar);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int insert(CustomerDto dto) {
		String query = "INSERT INTO customer(name, address, aadhar, dob, id, date,age) VALUES (?, ?, ?, ?, ?, ?,?)";
		Connection con = JDBCUtility.getConnection();
		int rs = 0;
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, dto.getName());
			pst.setString(2, dto.getAddress());
			pst.setString(3, dto.getAadhar());
			pst.setString(4, dto.getDob());
			pst.setString(5, dto.getId());
			pst.setString(6, dto.getDate());
			pst.setInt(7, dto.getAge());
			rs = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

}
