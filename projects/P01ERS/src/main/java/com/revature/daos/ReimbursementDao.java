package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;


public interface ReimbursementDao extends GenericDao<Reimbursement>{
	List<Reimbursement> viewPendingReimb(int authorId);	
	List<Reimbursement> viewResolvedReimb(User u);
	List<Reimbursement> getByEmployeeId(int id);
	boolean edit(Reimbursement r);
}
