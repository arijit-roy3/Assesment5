package com.test.pojo;

import java.sql.Date;

public class Courier {
	private int id;
	private String name;
	private String city;
	private String mobile;
	private String area;
	private double weight;
	private double distance;
	private double cost;
	private Date orderDate;
	private Date deliveryDate;
	private int trackingNo;
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public Courier() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getTrackingNo() {
		return trackingNo;
	}
	public void setTrackingNo(int trackingNo) {
		this.trackingNo = trackingNo;
	}
	public Courier(int id, String name, String city, String mobile, String area, double weight, double distance,
			double cost, Date orderDate, Date deliveryDate, int trackingNo) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.mobile = mobile;
		this.area = area;
		this.weight = weight;
		this.distance = distance;
		this.cost = cost;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.trackingNo = trackingNo;
	}
	
	
}
