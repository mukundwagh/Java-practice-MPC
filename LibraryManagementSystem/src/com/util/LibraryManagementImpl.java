package com.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.bean.Book;
import com.bean.Defaulter;
import com.bean.Transaction;

public class LibraryManagementImpl implements LibraryManagement {

	// populate the data
	@Override
	public List<Transaction> populateData() {

		List<Transaction> list = new ArrayList<Transaction>();

		DatabaseConnectionManager Dcm = new DatabaseConnectionManager();

		Connection connection;
		try {
			connection = Dcm.getConnection();

			Statement statement = connection.createStatement();
			
			String query = "SELECT transaction_tbl.studID,transaction_tbl.name,transaction_tbl.issueDate,transaction_tbl.returnDate,transaction_tbl.bookID,book_tbl.bookName,book_tbl.authorName FROM libdb.book_tbl,libdb.transaction_tbl where transaction_tbl.bookID=book_tbl.bookID";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				
				Book book= new Book(resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7));
				Transaction transaction = new Transaction(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getDate(4), resultSet.getInt(5), book);
				list.add(transaction);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
		
		return list;
		
	}

	// return list of defaulters who have not returned the book till date
	@Override
	public List<Defaulter> checkDefaulters(List<Transaction> list) {
		List<Defaulter> Dlist = new ArrayList<Defaulter>();

		Iterator<Transaction> iterT = list.iterator();

		while (iterT.hasNext()) {
			Transaction transaction = (Transaction) iterT.next();

			if (transaction.getReturnDate() == null) {

				Defaulter d = new Defaulter(transaction, 0, null);
				Dlist.add(d);

			}
		}

		// System.out.println(Dlist);

		return Dlist;

	}

	// calculate fine for defaulters
	// fine will be admissible after 20 days of issuing the book
	// fine=fine_days*5;
	@Override
	public void calculateFine(List<Defaulter> list) {
		// TODO Auto-generated method stub

		Iterator<Defaulter> iterator = list.iterator();

		while (iterator.hasNext()) {
			Defaulter defaulter = (Defaulter) iterator.next();
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(defaulter.getIssueDates());
			
			Calendar calendar2 = Calendar.getInstance();
			calendar2.getTime();
			
			long diff = calendar2.getTimeInMillis()- calendar.getTimeInMillis();
			int fine=(int) (TimeUnit.MILLISECONDS.toDays(diff)*5);
			
			defaulter.setFine(fine);
			
			
			
			
			/*Date issDate = defaulter.getIssueDates();
			Calendar cal = Calendar.getInstance();
			cal.setTime(issDate);

			Calendar tocal = Calendar.getInstance();

			//System.out.println(cal.getTime());

			cal.add(Calendar.DATE, 20);
			//System.out.println(cal.getTime());
			java.util.Date todate = tocal.getTime();
			java.util.Date issdate1 = cal.getTime();
			//System.out.println(issdate1);
			long diff = (todate.getTime() - issdate1.getTime())
					/ (1000 * 60 * 60 * 24);

			defaulter.setFine((int) (diff * 5));
			
			
			

			// System.out.println(diff);
*/
		}

	}

}
