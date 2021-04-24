package com.saveo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SaveoOrder")
public class SaveoOrderModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;

	public SaveoOrderModel(int order_id, String uniqueid, int quantity, String name) {
		super();
		this.order_id = order_id;
		this.uniqueid = uniqueid;
		this.quantity = quantity;
		this.name = name;
	}
	public SaveoOrderModel() {
		// TODO Auto-generated constructor stub
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getUniqueid() {
		return uniqueid;
	}
	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="c_unique_id")
	private String uniqueid;
	private int quantity;
	@Column(name="c_name")

	private String name;

}
