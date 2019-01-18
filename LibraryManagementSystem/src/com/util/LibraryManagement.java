package com.util;

import java.util.List;

import com.bean.Defaulter;
import com.bean.Transaction;

public interface LibraryManagement {

	public List<Transaction> populateData();
	public List<Defaulter> checkDefaulters(List<Transaction> list);
	public void calculateFine(List<Defaulter> list);
}
