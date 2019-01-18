package com.psl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Defaulter;
import com.bean.Transaction;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.util.DatabaseConnectionManager;
import com.util.LibraryManagementImpl;

public class Client {
	public static void main(String[] args) {

		
	LibraryManagementImpl Limp = new LibraryManagementImpl();
	List<Transaction> list = new ArrayList<Transaction>();
	list =Limp.populateData();
	List<Defaulter> dlist = new ArrayList<Defaulter>();	
	dlist =Limp.checkDefaulters(list);
		
	Limp.calculateFine(dlist);	
	System.out.println(dlist);	
		
		
	}
}
