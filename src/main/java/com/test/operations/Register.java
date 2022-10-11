package com.test.operations;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.dao.CourierDao;
import com.test.pojo.Courier;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=null;
		String name=request.getParameter("name");		
		String city=request.getParameter("city");		
		String mobile=request.getParameter("mobile");		
		String area=request.getParameter("area");
		double weight=Double.parseDouble(request.getParameter("weight"));
		double distance=Double.parseDouble(request.getParameter("distance"));
		
		Courier courier=new Courier();
		CourierDao dao=new CourierDao();
		courier.setName(name);
		courier.setCity(city);
		courier.setMobile(mobile);
		courier.setArea(area);
		courier.setWeight(weight);
		courier.setDistance(distance);
		 long millis=System.currentTimeMillis();  
	        java.sql.Date date=new java.sql.Date(millis);  
	    courier.setOrderDate(date);    
		try {
			dao.insertCourier(courier);
//			HttpSession session=request.getSession(); 
//	        session.setAttribute("cost",val.getCost()); 
//	        session.setAttribute("date",val.getDate()); 
//	        session.setAttribute("trackingNo",val.getTrackingNo()); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		dispatcher=request.getRequestDispatcher("table.jsp");
		dispatcher.forward(request, response);
	}

}
