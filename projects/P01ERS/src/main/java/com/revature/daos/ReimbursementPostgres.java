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
	public int add(Reimbursement r) {
		int res = -1;
		String sql = "insert into ers_reimbursement"
				+ "(reimb_amount, reimb_submitted, reimb_description, reimb_author,"
				+ " reimb_type_id, reimb_status_id)" + "values (?,?,?,?,?,?) returning reimb_id;";

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, r.getAmount());
			ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			ps.setString(3, r.getDescription());
			ps.setInt(4, r.getAuthor());
			ps.setInt(5, r.getType_Id());
			ps.setInt(6, r.getStatus_Id());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				res = rs.getInt("REIMB_ID");

			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Reimbursement getById(int id) {
		System.out.println("Here");
		String sql = "select * from ERS_REIMBURSEMENT where reimb_id = ? ";
		Reimbursement reimb = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				reimb = new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"), rs.getInt("reimb_author"), rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return reimb;

	}

	@Override
	public List<Reimbursement> getAll() {
		String sql = "select * from ERS_REIMBURSEMENT;";
		List<Reimbursement> reimbursement = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				Reimbursement r = new Reimbursement(
				 rs.getInt("REIMB_ID"),
				 rs.getInt("REIMB_AMOUNT"),
				 rs.getTimestamp("REIMB_SUBMITTED"),
				 rs.getTimestamp("REIMB_RESOLVED"),
				 rs.getString("REIMB_DESCRIPTION"),
				 rs.getInt("REIMB_AUTHOR"),
				 rs.getInt("REIMB_RESOLVER"),
				 rs.getInt("REIMB_STATUS_ID"),
				 rs.getInt("REIMB_TYPE_ID"));
				 reimbursement.add(r);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return reimbursement;
	}

//	@Override
//	public List<Reimbursement> viewPendingReimb(User u) {
//		String sql = "select * from ERS_REIMBURSEMENT where reimb_status_id = 2;";
//		ArrayList<Reimbursement> pendingList = new ArrayList<Reimbursement>();
//
//		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, u.getUserName());
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//
//				Reimbursement reimb = new Reimbursement(rs.getInt("reimb_amount"), rs.getTimestamp("reimb_submitted"),
//						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));
//
//				reimb.setId(rs.getInt("reimb_id"));
//				pendingList.add(reimb);
//			}
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//		}
//		return pendingList;
//
//	}

	@Override
	public List<Reimbursement> viewResolvedReimb(User u) {
		String sql = "select * from ERS_REIMBURSEMENT where reimb_status_id = 1;";
		ArrayList<Reimbursement> resolvedList = new ArrayList<Reimbursement>();

		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUserName());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
//  TODO I change the method for pending reim create the same one back
				Reimbursement reimb = new Reimbursement(rs.getInt("reimb_amount"), rs.getTimestamp("reimb_submitted"),
						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));

				reimb.setId(rs.getInt("reimb_id"));
				resolvedList.add(reimb);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return resolvedList;

	}

//	@Override
//	public int add(Reimbursement t) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int update(Reimbursement r) {
		int res = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "UPDATE ers_reimbursement SET reimb_resolved = ?, reimb_resolver= ?, reimb_status_id = ? WHERE reimb_id = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			ps.setInt(2, r.getResolver());
			ps.setInt(3, r.getStatus_Id());
			ps.setInt(4, r.getId());
			res = ps.executeUpdate();
			if (res > 0)
				return res;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Reimbursement> getByEmployeeId(int id) {
		System.out.println("you at postgres employee by id line 185");
		System.out.println(id);
		List<Reimbursement> rmbs = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "select * from ers_reimbursement where reimb_author = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimbursement r = new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"), rs.getInt("reimb_author"), rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));
				rmbs.add(r);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return rmbs;
	}

	@Override
	public List<Reimbursement> viewPendingReimb(int authorId) {
		System.out.println(authorId);
		String sql = "select * from ERS_REIMBURSEMENT where reimb_status_id = 2;";
		ArrayList<Reimbursement> pendingList = new ArrayList<Reimbursement>();

		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Reimbursement reimb = new Reimbursement(
						rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getInt("reimb_status_id"),
						rs.getInt("REIMB_AUTHOR"),
						rs.getInt("reimb_type_id"),
						rs.getInt("reimb_resolver"));

				reimb.setId(rs.getInt("reimb_id"));
				pendingList.add(reimb);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return pendingList;

	}
	@Override
	public boolean edit(Reimbursement r) {
		String sql = "update ers_reimbursement set reimb_amount = ?, reimb_submitted = ?, "
				+ "reimb_resolved = ?, reimb_description = ?, reimb_author = ?, reimb_resolver = ?, "
				+ "reimb_status_id = ?, reimb_type_id = ? where reimb_id = ?;";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			int rowsChanged = -1;
			ps.setDouble(1, r.getAmount());
			ps.setTimestamp(2, r.getSubmittedDate());
			ps.setTimestamp(3, r.getResolvedDate());
			ps.setString(4, r.getDescription());
			ps.setInt(5, r.getAuthor());
			ps.setInt(6, r.getResolver());
			ps.setInt(7, r.getStatus_Id());
			ps.setInt(8, r.getType_Id());

			rowsChanged = ps.executeUpdate();

			if (rowsChanged > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException | IOException c1) {
			c1.printStackTrace();
		}
		return false;
	}
	}


