package com.acn.google.workspacereservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rooms")
public class Rooms {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="room_id")
	private int room_id;
	
	@Column(name="room_number")
	private String room_number;
	
	@Column(name="room_type")
	private String room_type;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="status")
	private String status;

	public Rooms() {
	
	}

	public Rooms(int room_id, String room_number, String room_type, Double price, String status) {
		super();
		this.room_id = room_id;
		this.room_number = room_number;
		this.room_type = room_type;
		this.price = price;
		this.status = status;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getRoom_number() {
		return room_number;
	}

	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
