package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementPostgres;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public class ReimbursementService {

	private ReimbursementDao rs = new ReimbursementPostgres();

	public List<Reimbursement> viewPendingReimb(int authorId) {
		List<Reimbursement> reimTable = rs.viewPendingReimb(authorId);
		return reimTable;

	}

	public void viewResolvedReimb(User u) {
		List<Reimbursement> reimTable = rs.viewResolvedReimb(u);
	}

	public int add(Reimbursement r) {
		r.setStatus_Id(2);
		return rs.add(r);
	}

	public List<Reimbursement> getReimbursements() {
		return rs.getAll();
	}

	public int updateReim(Reimbursement r) {
		return rs.update(r);
	}

	public Reimbursement getById(int id) {
		return rs.getById(id);
	}

	public List<Reimbursement> getReimbursementsByEmployeeId(int id) {
		return rs.getByEmployeeId(id);
	}
}
