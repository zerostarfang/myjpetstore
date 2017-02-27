package com.petstore.domain;

/**
 * 供应商的信息
 * @author shishi
 *
 */
public class Supplier {
	private Integer suppid;
	private String supplierName;
	private  String status;
	private String addr1;
	private String addr2;
	private String city;
	private String state;
	private String zip;
	private String phone;
	public Integer getSuppid() {
		return suppid;
	}
	public void setSuppid(Integer suppid) {
		this.suppid = suppid;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
