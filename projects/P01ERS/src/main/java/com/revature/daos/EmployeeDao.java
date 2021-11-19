package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface EmployeeDao {

	boolean addReimbursementRequest(Reimbursement r);	
	ArrayList<Reimbursement> viewPendingReimb(User u);	
	ArrayList<Reimbursement> viewResolvedReimb(User u);
	
}
