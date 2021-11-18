package com.revature.services;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import java.util.ArrayList;
import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeePostgres;
;

public class EmployeeService {

	protected EmployeeDao ed;

	EmployeeService() {
		super();
		ed = new EmployeePostgres();
	}

	public boolean addReimbursementRequest(Reimbursement r) {
		if (ed.addReimbursementRequest(r)) {
			return true;
		}
		return false;
	}

	public void viewPendingReimb(User u) {
		ArrayList<Reimbursement> reimTable = ed.viewPendingReimb(u);

	}
	
	public void viewResolvedReimb(User u) {
		ArrayList<Reimbursement> reimTable = ed.viewResolvedReimb(u);
	}
}