package model;

public class Customer {

	private String name;
	private String username;
	private String password;
	private double balance;
	
	public Customer(String name, String username, String password, double balance)
	{
		this.name = name;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	public void withdraw(double amount)
	{
		if(balance < 0)
		{
			System.out.println("You can't withdraw a negative amount.");
			return;
		}
		
		if(balance >= amount)
		{
			balance = (balance - amount);
		}
		else
		{
			System.out.println("You can't withdraw more than you have.");
		}
	}
	
	public void deposit(double amount)
	{
		if(amount > 0)
		{
			balance = (balance + amount);
		}
		else if(amount == 0)
		{
			System.out.println("You're depositing 0 dollars.");
		}
		else
		{
			System.out.println("You can't deposit a negative amount.");
		}
	}
	
	public double getBalance() {
		return balance;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}