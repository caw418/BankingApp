package main;

import java.util.Scanner;

import model.Bank;
import model.Customer;

public class App {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {

		String username;
		String password;
		int userInput;
		Bank bank = new Bank();
		Customer customer;
		double amount;
		
		do
		{
			System.out.println("1 - Login");
			System.out.println("2 - Open an account");
			userInput = console.nextInt();
			if(userInput == 1)
			{
				System.out.println("Enter your username: ");
				username = console.next();
				System.out.println("Enter your password: ");
				password = console.next();
				customer = bank.getCustomer(username, password);
				try
				{
					System.out.println("Welcome, " + customer.getName() + "!");
				}
				catch(NullPointerException e)
				{
					System.out.println("Invalid username and/or password");
					e.printStackTrace();
					System.exit(0);
				}
				
				do
				{
					System.out.println("1 - Check Balance");
					System.out.println("2 - Deposit");
					System.out.println("3 - Withdraw");
					userInput = console.nextInt();
					switch(userInput)
					{
					case 1:
						System.out.println(customer.getBalance());
						break;
					case 2:
						System.out.println("Enter the amount to deposit: ");
						amount = console.nextDouble();
						customer.deposit(amount);
						break;
					case 3:
						System.out.println("Enter the amount to withdraw: ");
						amount = console.nextDouble();
						customer.withdraw(amount);
						break;
					}
					System.out.println("1 - Select another option, 2 - Logout");
					userInput = console.nextInt();
				}
				while(userInput == 1);
			}
			else
			{
				System.out.println("Enter your first name and last name");
				String name = console.next() + console.nextLine();
				System.out.println("Enter your username: ");
				username = console.next();
				while(bank.checkUsername(username))
				{
					System.out.println("Username unavailable");
					System.out.println("Enter your username: ");
					username = console.next();
				}
				System.out.println("Enter your password: ");
				password = console.next();
				try
				{
					bank.addCustomer(name, username, password);
				}
				catch(Exception e)
				{
					System.out.println("Failed to Open Account");
					e.printStackTrace();
				}
				System.out.println("Successfully Opened Account");
			}
			System.out.println("Back to main menu? 1 - Yes, 2 - No");
			userInput = console.nextInt();
		} while(userInput == 1);
	}
}