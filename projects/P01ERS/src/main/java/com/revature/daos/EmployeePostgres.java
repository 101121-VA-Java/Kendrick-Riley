package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

import Utilites.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao {

	@Override
	public boolean addReimbursementRequest(Reimbursement r) {
	String sql = "INSERT INTO ERS_REMBURSEMENT(reimb_amount, reimb_submitted, reimb_description, "
			+ "reimb_author, reim_status_id) + values (?, ?, ?, ?, ?)"; 
	try (Connection con = ConnectionUtil.getConnectionFromFile()) {
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setDouble(1, r.getAmount());
		ps.setString(2, r.getSubmittedDate());
		ps.setString(3, r.getDescription());
		ps.setInt(4, r.getAuthor().getUserId());
		ps.setInt(5, r.getStatus_Id().getStatusId());
		ps.executeUpdate();
		return true;
		
	} catch (SQLException | IOException e) {			
		e.printStackTrace();
		return false;
	}
			
	
}
	
	
	
	

	@Override
	public ArrayList<Reimbursement> viewPendingReimb(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimbursement> viewResolvedReimb(User u) {
		// TODO Auto-generated method stub
		return null;
	}


}
