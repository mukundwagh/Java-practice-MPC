
package com.client;

import java.beans.Statement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.beans.Peripheral;

public class Client {

	public static void main(String[] args) {
		/* write your code here */

		Set<Peripheral> peripherals = new LinkedHashSet<Peripheral>();
		readPeripheralInventory(peripherals);
		System.out.println(peripherals);

		insertPeripheralRecords(peripherals);
		Set<Peripheral> tree = new TreeSet<Peripheral>();
		tree = sortInventoryByPrice(peripherals);
		System.out.println(tree);
		
		tree= sortInventoryByQuantityPrice(peripherals);
		System.out.println(tree);
		
		Set<Peripheral> set= new LinkedHashSet<Peripheral>();
		set = filterInventoryByPrice(500, 1500, peripherals);
		System.out.println(set);
	}

	/**
	 * this method will read peripheral details from the CSV file given to you
	 * and populate the Set
	 */
	public static void readPeripheralInventory(Set<Peripheral> peripherals) {
		/* write your code here */

		try {
			FileReader fr = new FileReader("Peripherals.txt");
			BufferedReader bf = new BufferedReader(fr);

			String str;
			String[] data;
			while ((str = bf.readLine()) != null) {

				if (str.contentEquals("")) {
					continue;
				}

				else {

					data = str.split(",");
					Peripheral ph = new Peripheral(data[0], data[1], data[2],
							Integer.parseInt(data[3]),
							Integer.parseInt(data[4]));

					peripherals.add(ph);

				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * this method will insert the peripheral information read earlier into a
	 * database table
	 */
	public static void insertPeripheralRecords(Set<Peripheral> peripherals) {
		/* write your code here */

		Iterator<Peripheral> iter = peripherals.iterator();

		while (iter.hasNext()) {
			Peripheral peripheral = (Peripheral) iter.next();
			String query = "insert into peripherals.peri (itemCode,name,description,price,quantity) values('"
					+ peripheral.getItemCode()
					+ "' , '"
					+ peripheral.getName()
					+ "' , '"
					+ peripheral.getDescription()
					+ "' ,"
					+ peripheral.getPrice()
					+ ","
					+ peripheral.getQuantity()
					+ ");";

			try {

				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost/peripherals", "root", "root");
				java.sql.Statement st = con.createStatement();
				((java.sql.Statement) st).executeUpdate(query);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * this method will sort a given Set by price in the ascending order. It
	 * will create a new ordered Set and return it.
	 */
	public static Set<Peripheral> sortInventoryByPrice(
			Set<Peripheral> peripherals) {
		/* write your code here */

		Set<Peripheral> tree = new TreeSet<Peripheral>(new sort());
		tree.addAll(peripherals);
		return tree;
	}

	/**
	 * this method will sort a given Set by quantity in the ascending order.
	 * Peripherals with the same quantity should be sorted amongst themselves by
	 * price in the ascending order. It will return a new Set with the sorted
	 * objects
	 */
	public static Set<Peripheral> sortInventoryByQuantityPrice(
			Set<Peripheral> peripherals) {
		/* write your code here */
		
		Set<Peripheral> treep = new TreeSet<Peripheral>(new Sortbyq());
		
		treep.addAll(peripherals);
		
		return treep;
	}

	/**
	 * this method will return a new Set with records filtered from an existing
	 * Set on the basis of price. Both prices are inclusive.
	 */
	public static Set<Peripheral> filterInventoryByPrice(int startingPrice,
			int endingPrice, Set<Peripheral> peripherals) {
		/* write your code here */
		Set<Peripheral> temp = new LinkedHashSet<Peripheral>();
		
		Iterator<Peripheral> iter = peripherals.iterator(); 
		
		while (iter.hasNext()) {
			Peripheral peripheral = (Peripheral) iter.next();
			
			if(peripheral.getPrice()>startingPrice && peripheral.getPrice()<endingPrice)
			{
				temp.add(peripheral);
			}
		}
		
		return temp;
	}
}
