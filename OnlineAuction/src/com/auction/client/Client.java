package com.auction.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import com.auction.bean.Auction;
import com.auction.bean.Bid;
import com.auction.bean.Item;
import com.auction.bean.User;
import com.auction.util.AuthenticationFailureException;

public class Client {

	public static void main(String[] args) {
		/*
		 * create a menu based system wherein user's will first login and then
		 * perform operations like add new item, auction an item, bid for an
		 * item, view items on auction, view bids received
		 */

		Item i = new Item(1, "i1", "deiption", 123.1, 5);
		Auction a = new Auction(1, i, Date.valueOf("2014-08-08"),
				Date.valueOf("2014-08-11"), 50.25, 100.25);
		Bid b = new Bid(1, i, 123);
		Set<Item> set = new HashSet<Item>();
		set.add(i);
		User u = new User(1, "Clark Kent", "superman", set);

		Client c = new Client();
		try {
			c.authenticateUser(u);
		} catch (AuthenticationFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// c.insertItemForUser(i, u);
		// c.getAllItemsForUser(u);
		// c.createAuction(a);
		// c.createBid(b);
		c.getAllBidsForItem(i);
	}

	public void authenticateUser(User user)
			throws AuthenticationFailureException {
		System.out.println("AUTHENTICATE USER");
		// System.out.println(user.getUserId()+" "+user.getUsername()+" "+user.getPassword());
		File f = new File("users.csv");
		boolean id = false, uname = false, pass = false, valid = false;
		String line;
		String[] arr;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f));
			while ((line = br.readLine()) != null) {
				arr = line.split(",");
				for (int i = 0; i < arr.length; i++) {
					// System.out.print(arr[i]);
					if (i == 0) {
						int id1 = Integer.parseInt(arr[0]);
						if (id1 == user.getUserId()) {
							id = true;
						}

					}
					if (i == 1) {
						if (arr[1].equals(user.getUsername())) {
							uname = true;
						}
					}

					if (i == 2) {
						if (arr[2].equals(user.getPassword())) {
							pass = true;
						}
					}
				}

				// System.out.println("");
			}
			if (id == true && uname == true && pass == true) {
				System.out.println("valid user");

			} else
				throw new AuthenticationFailureException("invlid user");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void insertItemForUser(Item item, User user) {

		System.out.println("INSERT ITEM FOR USER");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn;

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/online_auction_db", "root", "root");

			PreparedStatement pst = conn
					.prepareStatement("insert into items values(?,?,?,?,?,?)");
			pst.setInt(1, item.getItemId());
			pst.setInt(2, user.getUserId());
			pst.setString(3, item.getItemName());
			pst.setString(4, item.getDescription());
			pst.setDouble(5, item.getStartingPrice());
			pst.setInt(6, item.getQuantity());
			pst.executeUpdate();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createAuction(Auction auction) {
		System.out.println("CREATE AUCTION");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn;

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/online_auction_db", "root", "root");

			PreparedStatement pst = conn
					.prepareStatement("insert into auctions values(?,?,?,?,?,?)");
			pst.setInt(1, auction.getAuctionId());
			pst.setInt(2, auction.getItem().getItemId());
			pst.setDate(3, auction.getStartDate());
			pst.setDate(4, auction.getEndDate());
			pst.setDouble(5, auction.getMinumumIncrement());
			pst.setDouble(6, auction.getShippingCharges());
			pst.executeUpdate();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createBid(Bid bid) {
		System.out.println("CREATE BID");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn;

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/online_auction_db", "root", "root");

			PreparedStatement pst = conn
					.prepareStatement("insert into bids values(?,?,?)");
			pst.setInt(1, bid.getBidId());
			pst.setInt(2, bid.getItem().getItemId());
			pst.setDouble(3, bid.getBidAmount());
			pst.executeUpdate();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Set<Bid> getAllBidsForItem(Item item) {
		System.out.println("---GET ALL BIDS---");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn;

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/online_auction_db", "root", "root");

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from bids where itemId="
					+ item.getItemId());
			while (rs.next()) {

				System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(2));
				System.out.println(rs.getDouble(3));
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void getAllItemsForUser(User user) {
		System.out.println("----GET ALL ITEMS----");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn;

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/online_auction_db", "root", "root");

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from items where userId="
					+ user.getUserId());
			while (rs.next()) {
				
				System.out.println(rs.getInt("itemId"));
				System.out.println(rs.getInt("userId"));
				System.out.println(rs.getString("itemName"));
				System.out.println(rs.getString("description"));
				System.out.println(rs.getDouble("startingPrice"));
				System.out.println(rs.getInt("quantity"));
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Set<Auction> getAllItemsOnAuction(User user) {
		Set<Auction> set=new HashSet<Auction>();
		
		System.out.println("----GET ALL ITEMS----");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn;

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/online_auction_db", "root", "root");

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from items where userId="
					+ user.getUserId());
			while (rs.next()) {
				
				System.out.println(rs.getInt("itemId"));
				System.out.println(rs.getInt("userId"));
				System.out.println(rs.getString("itemName"));
				System.out.println(rs.getString("description"));
				System.out.println(rs.getDouble("startingPrice"));
				System.out.println(rs.getInt("quantity"));
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
