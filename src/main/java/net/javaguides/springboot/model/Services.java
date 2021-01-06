package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="service5")

public class Services {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="Service_request_date")
    @NotNull(message = "Please provide date in 'yyyy-mm-dd' format.")
    private String Service_request_date;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="Date_Of_Service")
    @NotNull(message = "Please provide date in 'yyyy-mm-dd' format.")
    private String Date_Of_Service;
	
	@Column(name="Service_Desc",nullable=false)
	@Size(min = 5, message = "Describtion can be atleast 200 characters long.")
	private String Service_Desc;
	
	@Column(name="service_charge",nullable=false)
	@Size(min = 3, message = "Charge can be atleast 10 characters long.")
	private String service_charge;
	
	@Column(name="Service_status",nullable=false)
	@Size(min = 5, message = "Status can be atleast 50 characters long.")
	private String Service_status;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="Delivery_Date")
    @NotNull(message = "Please provide date in 'yyyy-mm-dd' format.")
	private String Delivery_Date;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="Last_updated_date")
    @NotNull(message = "Please provide date in 'yyyy-mm-dd' format.")
	private String Last_updated_date;
	
	@NotNull
    @Size(min = 2, message = "Registration Number should have atleast 20 characters")
    private String veh_reg_Number;
	
	public Services() {
		super();
	}

	public Services(long id,
			 String service_request_date, String date_Of_Service,String service_Desc,String service_charge,
			 String service_status,String delivery_Date, String last_updated_date,String veh_reg_Number) {
		//super();
		this.id = id;
		this.Service_request_date = service_request_date;
		this.Date_Of_Service = date_Of_Service;
		this.Service_Desc = service_Desc;
		this.service_charge = service_charge;
		this.Service_status = service_status;
		this.Delivery_Date = delivery_Date;
		this.Last_updated_date = last_updated_date;
		this.veh_reg_Number = veh_reg_Number;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getService_request_date() {
		return Service_request_date;
	}

	public void setService_request_date(String service_request_date) {
		Service_request_date = service_request_date;
	}

	public String getDate_Of_Service() {
		return Date_Of_Service;
	}

	public void setDate_Of_Service(String date_Of_Service) {
		Date_Of_Service = date_Of_Service;
	}

	public String getService_Desc() {
		return Service_Desc;
	}

	public void setService_Desc(String service_Desc) {
		Service_Desc = service_Desc;
	}

	public String getService_charge() {
		return service_charge;
	}

	public void setService_charge(String service_charge) {
		this.service_charge = service_charge;
	}

	public String getService_status() {
		return Service_status;
	}

	public void setService_status(String service_status) {
		Service_status = service_status;
	}

	public String getDelivery_Date() {
		return Delivery_Date;
	}

	public void setDelivery_Date(String delivery_Date) {
		Delivery_Date = delivery_Date;
	}

	public String getLast_updated_date() {
		return Last_updated_date;
	}

	public void setLast_updated_date(String last_updated_date) {
		Last_updated_date = last_updated_date;
	}

	public String getVeh_reg_Number() {
		return veh_reg_Number;
	}

	public void setVeh_reg_Number(String veh_reg_Number) {
		this.veh_reg_Number = veh_reg_Number;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", Service_request_date=" + Service_request_date + ", Date_Of_Service="
				+ Date_Of_Service + ", Service_Desc=" + Service_Desc + ", service_charge=" + service_charge
				+ ", Service_status=" + Service_status + ", Delivery_Date=" + Delivery_Date + ", Last_updated_date="
				+ Last_updated_date + ", veh_reg_Number=" + veh_reg_Number + "]";
	}
	
	

}
