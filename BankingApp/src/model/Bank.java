package model;

import java.util.ArrayList;

public class Bank {

	private ArrayList<Customer> custList = new ArrayList<>();
	
	public Bank()
	{
		Customer Angela = new Customer("Angela Brooks", "abrooks", "password", 100000);
		Customer Ayane = new Customer("Ayane Sato", "asato", "password", 200000);
		Customer Samantha = new Customer("Samantha Jennnings", "sjennings", "password", 300);
		Customer Brooke = new Customer("Brooke Kim", "bkim", "password", 500);
		custList.add(Angela);
		custList.add(Ayane);
		custList.add(Samantha);
		custList.add(Brooke);
	}
	
	public Customer getCustomer(String username, String password)
	{
		for(Customer cust : custList)
		{
			if(cust.getUsername().equals(username) && cust.getPassword().equals(password))
			{
				return cust;
			}
		}
		return null;
	}
	
	public boolean checkUsername(String username)
	{
		for(Customer cust : custList)
		{
			if(cust.getUsername().equals(username))
			{
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Customer> getCustList()
	{
		return custList;
	}
	
	public void addCustomer(String name, String username, String password)
	{
		Customer cust = new Customer(name, username, password, 0);
		custList.add(cust);
	}
}