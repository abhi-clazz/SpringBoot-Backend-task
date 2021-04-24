package com.saveo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SaveoProduct")

public class SaveoModel 
{
	@Column(name="c_unique_id")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="c_name")
	private String name;
	@Column(name="c_batch_no")

	private String batchNumber;
	
	@Column(name="d_expiry_date")

	private String expDate;
	@Column(name="n_balance_qty")

	private int stockbalance;
	@Column(name="c_packaging")

	private String packing;
	@Column(name="c_unique_code")

	private String uniqueCode;
	@Column(name="c_schemes")

	private String scheme;
	
	@Column(name="n_mrp")

	private Double mrp;
	

	@Column(name="c_manufacturer")
	private String manufacturer;
	
	@Column(name="hsn_code")
	
	private String hsnCode;
	
	public SaveoModel() 
	{
		
	}
	public SaveoModel(Integer id,String name, String batchNumber, String expDate, int stockbalance, String packing,
			String uniqueCode, String scheme, Double mrp, String manufacturer, String hsnCode) {
		super();
		this.name = name;
		this.batchNumber = batchNumber;
		this.expDate = expDate;
		this.stockbalance = stockbalance;
		this.packing = packing;
		this.uniqueCode = uniqueCode;
		this.scheme = scheme;
		this.mrp = mrp;
		this.manufacturer = manufacturer;
		this.hsnCode = hsnCode;
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public int getStockbalance() {
		return stockbalance;
	}
	public void setStockbalance(int stockbalance) {
		this.stockbalance = stockbalance;
	}
	public String getPacking() {
		return packing;
	}
	public void setPacking(String packing) {
		this.packing = packing;
	}
	public String getUniqueCode() {
		return uniqueCode;
	}
	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public Double getMrp() {
		return mrp;
	}
	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

}

