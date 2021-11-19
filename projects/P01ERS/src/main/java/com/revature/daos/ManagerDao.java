package com.revature.daos;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ManagerDao {

	Reimbursement viewPendingRequests();

	Reimbursement viewAllResolved();

	boolean updateRequest(Reimbursement r);

	Reimbursement viewSingleRequest(User u);

	User viewAllEmp();

}
