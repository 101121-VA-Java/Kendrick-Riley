package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

import Utilites.ConnectionUtil;

public class ReimbursementPostgres implements ReimbursementDao {

	@Override
	public Reimbursement add(Reimbursement r) {
		Reimbursement newReim = null;
		String sql = "insert into ERS_REIMBURSEMENTS (REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REMI_TYPE_ID) values (?, ?, ?, ?, ?, ?, ?, ?) returning REIMB_ID;";

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, r.getAmount());
			ps.setTimestamp(2, r.getSubmittedDate());
			ps.setTimestamp(3, r.getResolvedDate());
			ps.setString(4, r.getDescription());
			ps.setInt(5, r.getAuthor().getUserId());
			ps.setInt(6, r.getResolver().getUserId());
			ps.setInt(7, r.getStatus_Id().getStatusId());
			ps.setInt(8, r.getType_Id().getTypeId());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				newReim.setId(rs.getInt("REIMB_ID"));

			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return newReim;
	}

	@Override
	public Reimbursement getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAll() {
		String sql = "select * from ERS_REIMBURSEMENTS;";
		List<Reimbursement> reimbursement = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("REIMB_AMOUNT");
				Timestamp submittedDate = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp resolvedDate = rs.getTimestamp("REIMB_RESOLVED");
				String description = rs.getString("REIMB_DESCRIPTION");
				int author = rs.getInt("REIMB_AUTHOR");
				int resolver = rs.getInt("REIMB_RESOLVER");
				int status_Id = rs.getInt("REIMB_STATUS_ID");
				int type_Id = rs.getInt("REMI_TYPE_ID");
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return reimbursement;
	}

	@Override
	public boolean update(Reimbursement t) {
		// TODO Auto-generated method stub
		return false;
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
