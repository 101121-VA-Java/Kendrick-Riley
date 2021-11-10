package com.revature.services;

import java.util.List;

import com.revature.daos.PaymentDao;
import com.revature.models.Payment;
import com.revature.repositories.PaymentPostgres;

public class PaymentService {
	
	private static PaymentDao pd = new PaymentPostgres();

	public Payment add(Payment payment) {
		return pd.add(payment);
	}

}