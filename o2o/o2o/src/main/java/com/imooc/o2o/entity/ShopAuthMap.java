package com.imooc.o2o.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name="tb_shop_auth_map")
public class ShopAuthMap {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long shopAuthId;
	
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="shop_id")
	private Long shopId;
	
	private String name;
	
	private String title;
	
	@Column(name="title_flag")
	private Integer titleFlag;
	
	@Column(name="enable_status")
	private Integer enableStatus;
	
	@Column(name="create_time")
	private Date createTime;
	
	@Column(name="last_edit_time")
	private Date lastEditTime;
	
	@Transient
	private PersonInfo employee;
	
	@Transient
	private Shop shop;

	public Long getShopAuthId() {
		return shopAuthId;
	}

	public void setShopAuthId(Long shopAuthId) {
		this.shopAuthId = shopAuthId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getTitleFlag() {
		return titleFlag;
	}

	public void setTitleFlag(Integer titleFlag) {
		this.titleFlag = titleFlag;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public PersonInfo getEmployee() {
		return employee;
	}

	public void setEmployee(PersonInfo employee) {
		this.employee = employee;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String toString() {
		return "[shopId=" + shopId + ", employeeId=" + employeeId
				+ ", employeeName=" + name + "]";
	}
}
