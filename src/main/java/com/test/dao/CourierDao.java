package com.test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;


import com.test.pojo.Courier;



public class CourierDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/allstates?useSSL=true";
	private String jdbcloanname = "root";
	private String jdbcPassword = "password";

	private static final String INSERT_COURIER_SQL = "INSERT INTO courier" + "  (name,city,mobile,area,weight,distance,cost,orderDate,delivery,trackingNo) VALUES "
			+ " (?, ?, ?,?,?,?,?,?,?,?);";

	private static final String SELECT_ALL_COURIERS="Select * from courier";
	
	public CourierDao() {}
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcloanname, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertCourier(Courier courier) throws SQLException {
		System.out.println(INSERT_COURIER_SQL);		
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COURIER_SQL)) {
			preparedStatement.setString(1,courier.getName());
			preparedStatement.setString(2,courier.getCity());
			preparedStatement.setString(3,courier.getMobile());
			preparedStatement.setString(4,courier.getArea());
			preparedStatement.setDouble(5,courier.getWeight());
			preparedStatement.setDouble(6,courier.getDistance());
			double cost=CourierDao.getCost(courier);
			preparedStatement.setDouble(7,cost);			 
			
			preparedStatement.setDate(8,courier.getOrderDate());
			LocalDate deliveryDate=getDate(courier.getOrderDate(),courier.getDistance());
			preparedStatement.setDate(9,java.sql.Date.valueOf( deliveryDate ));			
			int tracking=CourierDao.getTrackingNo(courier);
			preparedStatement.setInt(10,tracking);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
	}
	public static double getCost(Courier courier) {
		
		double cost=150;
		
       if(courier.getDistance()>500) {
       	cost+=500*0.5;
       }else if(courier.getDistance()>1000) {
    	   cost+=1000*0.7;
       }else if(courier.getDistance()>2000) {
    	   cost+=2000*0.9;
       }
       return cost;
	}
	public static LocalDate getDate(Date date,double distance) {
		
		LocalDate date1=date.toLocalDate();
		if(distance<500) {
			return date1.plusDays(1);
		}else if(distance<1000) {
			return date1.plusDays(2);
		}else if(distance<2000) {
			return date1.plusDays(4);
		}
		else {
			return date1.plusDays(7);
		}

		
	}
	public static int getTrackingNo(Courier courier) {
		int min = 100;  
		int max = 999;  
		return (int)(Math.random()*(max-min+1)+min);  
	}
	public List<Courier> selectAllCouriers() {
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Courier> courierDetails = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COURIERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String city = rs.getString("city");				
				String mobile=rs.getString("mobile");
				String area=rs.getString("area");
				Double weight = rs.getDouble("weight");
				Double distance = rs.getDouble("distance");
				Double cost=rs.getDouble("cost");
				Date orderDate=rs.getDate("orderDate");
			    Date deliveryDate = rs.getDate("delivery");
			    int trackingNo=rs.getInt("trackingNo");
			    
			    
				
				courierDetails.add(new Courier(id,name,city, mobile,area,weight,distance,cost,orderDate,deliveryDate,trackingNo));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courierDetails;
	}
	
}
