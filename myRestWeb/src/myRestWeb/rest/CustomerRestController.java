package myRestWeb.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import myRestWeb.entity.Address;
import myRestWeb.entity.Payment;
import myRestWeb.entity.Customer;
import myRestWeb.exceptions.CustomerNotFoundException;


@RestController
@RequestMapping("/api")
public class CustomerRestController {

	List<Customer> theCustomers = new ArrayList<>();
	private static Date randomDate(String beginDate,String  endDate ){  

		try {  

		SimpleDateFormat format = new SimpleDateFormat("MMddyyyy");  

		Date start = format.parse(beginDate);

		Date end = format.parse(endDate);

		if(start.getTime() >= end.getTime()){  

		return null;  

		}  

		long date = random(start.getTime(),end.getTime());  

		return new Date(date);  

		} catch (Exception e) {  

		e.printStackTrace();  

		}  

		return null;  

		}  

		private static long random(long begin,long end){  

		long rtn = begin + (long)(Math.random() * (end - begin));  


		if(rtn == begin || rtn == end){  

		return random(begin,end);  

		}  

		return rtn;  

		}  
	
	
	 public static String convertXmlGregorianToString(XMLGregorianCalendar xc)
	    {
	        DateFormat df = new SimpleDateFormat("MMddyyyy");
	 
	        GregorianCalendar gCalendar = xc.toGregorianCalendar();
	 
	        Date date = gCalendar.getTime();
	 
	        String dateString = df.format(date);
	 
	        return dateString;
	    }
	 
	 public static XMLGregorianCalendar ramdomBirthday() throws DatatypeConfigurationException {
		 
		 GregorianCalendar cal = new GregorianCalendar();
			Date randomBirthDate=randomDate("01011990","01012012"); 
	        cal.setTime(randomBirthDate);
	        XMLGregorianCalendar xCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
	         
	       return xCal;
	        
		 
	 }
	 
	 
	@PostConstruct
	public void intitialCustomers() throws DatatypeConfigurationException {
		
		
		
		Customer c1=new Customer("Tom","Cat",ramdomBirthday(),null,"TomCat@gmail.com","0123456789","M",null);
		c1.setAddress(new Address(123,"no mouse","cat town","qc","canada","a1a1a1"));
		c1.setPayment(new Payment("master","123423412341234"));
		
	
		Customer c2=new Customer("Tony","Cat",ramdomBirthday(),null,"TonyCat@gmail.com","9876543210","M",null);
		c2.setAddress(new Address(125,"no mouse","cat town","qc","canada","a1a1a1"));
		c2.setPayment(new Payment("master","432143214321"));
		
	
	
		Customer c3=new Customer("Jacob","Mouse",ramdomBirthday(),null,"JacobMouse@gmail.com","345678898","F",null);
		c3.setAddress(new Address(657,"no cat","mouse town","qc","canada","c1c1c1"));
		c3.setPayment(new Payment("master","1234432112344321"));
		
		
		Customer c4=new Customer("Jerry","Mouse",ramdomBirthday(),null,"JerryMouse@gmail.com","2345678910","M",null);
		c4.setAddress(new Address(345,"no cat","mouse town","qc","canada","c1c1c1"));
		c4.setPayment(new Payment("master","1234432112344321"));
		
		
		Customer c5=new Customer("MiuMiu","Cat",ramdomBirthday(),null,"MiuMiuCat@gmail.com","1234567890","F",null);
		c5.setAddress(new Address(128,"no mouse","cat town","qc","canada","b1b1b1"));
		c5.setPayment(new Payment("master","1234432112344321"));
		
		theCustomers = new ArrayList<>();
		theCustomers.add(c1);
		theCustomers.add(c2);
		theCustomers.add(c3);
		theCustomers.add(c4);
		theCustomers.add(c5);
	}
	// get the list of all customers
	@GetMapping("/customers")
	
	public List<Customer> getCustomers() {

		return theCustomers;
	}
// get the customer by id 	
	@GetMapping("/customers/{customerId}")
public Customer getCustomer(@PathVariable int customerId) {	
		
		if(customerId>=theCustomers.size()||customerId<0)
			throw new CustomerNotFoundException("Customer id not found -  " + customerId);
		return theCustomers.get(customerId);
	}
	
// get the customers list by city	
@GetMapping("/customers/find/city/{someCity}")
	public List<Customer> getCustomersByCity(@PathVariable String someCity)
	{
		List<Customer> customersByCity =new ArrayList<Customer>();
		

	   for (Customer c : theCustomers) {
			if (c.getAddress().getCity().equals(someCity))
		
				customersByCity.add(c);
			}
	
		if(customersByCity.size()>0)
			
		return customersByCity;
		else {
			throw new CustomerNotFoundException("Customer in "+someCity +" not found");
		}
		}
//sort the customer list by family
	
	@GetMapping("/customers/sorted/family")
	public List<Customer> getCustomersSortedByFamily(){
		 Collections.sort(theCustomers, (c1, c2) -> {
			  return ((Customer) c1).getFamily().compareTo(((Customer) c2).getFamily());
	        });
		 return theCustomers;
	}
	
	//sort the customer list by date of birth
	
	@GetMapping("/customers/sorted/birthday")
	public List<Customer> getCustomersSortedByDob(){
		 Collections.sort(theCustomers, (c1, c2) -> {
			  return ((Customer) c1).getBirthdate().compare(((Customer)c2).getBirthdate());
	        });
		 return theCustomers;
	}
	
	// find customers by family 
	@GetMapping("/customers/find/family/{family}")
	public List<Customer> getCustomersByFamily(@PathVariable String family){
		
		List<Customer> customersByFamily =new ArrayList<Customer>();
		

		   for (Customer c : theCustomers) {
				if (c.getFamily().toLowerCase().equals(family.toLowerCase()))
			
					customersByFamily.add(c);
				}
		
			if(customersByFamily.size()>0)
				
			return customersByFamily;
			else {
				throw new CustomerNotFoundException("Customer in the family -- "+family +" not found");
			}
	
	}
	// find customers by family 
	@GetMapping("/customers/find/name/{name}")
public List<Customer> getCustomersByName(@PathVariable String name){
	
		List<Customer> customersByName =new ArrayList<Customer>();

		   for (Customer c : theCustomers) {
				if (c.getName().toLowerCase().contains(name))
			
					customersByName.add(c);
				}
		
			if(customersByName.size()>0)
				
			return customersByName;
			else {
				throw new CustomerNotFoundException("Customer name -- "+name +" not found");
			}
	
	}
	
// delete customer by id 
	@DeleteMapping("/customers/{id}")
	
	public List<Customer> deletPassengerById(@PathVariable int id)
	
	{
		if(id>=theCustomers.size()||id<0)
			throw new CustomerNotFoundException("passenger id not found -  " + id);
		else
			theCustomers.remove(id);
		
		return theCustomers;
	}
	
	
//simple test of postMapping	
	 @PostMapping("/customers/name/{name}/family/{family}")
	 
	 public List<Customer> addCustomers(@PathVariable String name,@PathVariable String family)
	 {
		 Customer customer=new Customer(name, family);
		 
		 theCustomers.add(customer);
		 
		 return theCustomers;
		 
		 
	 }
	
//simple test of putmapping 
	 @PutMapping("/customers/{id}/name/{name}/family/{family}")
	 public List<Customer> updateCustomers(@PathVariable int id,@PathVariable String name,@PathVariable String family)
	 {
		 if(getCustomer(id)==null)
		 throw new CustomerNotFoundException("Customer id not found -  " + id);
		 else {
			theCustomers.get(id).setName(name);
			theCustomers.get(id).setFamily(family);
		}
		 
		 return theCustomers;
		 
	 }
}
