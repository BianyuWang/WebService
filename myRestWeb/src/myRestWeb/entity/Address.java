package myRestWeb.entity;

public class Address {
	
	private int number;
	private String  street;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	
	
	public Address(int number, String street, String city, String state, String country, String zipcode) {
		super();
		this.number = number;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
}
