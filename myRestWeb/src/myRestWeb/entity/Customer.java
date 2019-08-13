package myRestWeb.entity;

import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Customer   {
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String family,XMLGregorianCalendar date, Address address, String email, String phone,
			String gender, Payment payment) {
		super();
		this.name = name;
		this.family = family;
		this.birthdate = date;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.payment = payment;
	}
	
	public Customer(String name, String family) {
		super();
		this.name = name;
		this.family = family;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public XMLGregorianCalendar getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(XMLGregorianCalendar birthdate) {
		this.birthdate = birthdate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	private String name;
	private String family;
	@JsonFormat(pattern="yyyy-MM-dd")
	private XMLGregorianCalendar birthdate;
	private Address address;
	private String email;
	private String phone;
	private String gender;
	private Payment payment;


}
