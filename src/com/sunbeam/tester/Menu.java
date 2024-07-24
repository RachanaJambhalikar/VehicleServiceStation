package com.sunbeam.tester;

import java.util.Scanner;

public class Menu {
	public static int displayMainMenu(Scanner sc)
	{
		System.out.println("----------Main Menu----------");
		System.out.println("0. Exit");
		System.out.println("1. Customer");
		System.out.println("2. Vehicle");
		System.out.println("3. Service Request");
		System.out.println("4. Parts");
		System.out.println("5. Today's Business");
		System.out.println("6. Given Date's Business");
        System.out.print("Enter your choice: ");
		return sc.nextInt();	
	}
	public static int customerMenu(Scanner sc)
	{
		System.out.println("----------Customer Menu----------");
		System.out.println("0. Exit");
		System.out.println("1. Add customer");
		System.out.println("2. display all customers");
		System.out.println("3. display specific customer");
		System.out.println("4. edit customer");
		System.out.println("5. delete customer");
		System.out.println("Enter your choice: ");
		return sc.nextInt();	
	}
	public static int vehicleMenu(Scanner sc)
	{
		System.out.println("----------Vehicle Menu----------");
		System.out.println("0. Exit");
		System.out.println("1. Add vehicle");
		System.out.println("2. display all vehicles");
		System.out.println("3. display specific vehicle");
		System.out.println("4. edit vehicle");
		System.out.println("5. delete vehicle");
		System.out.println("Enter your choice: ");
		return sc.nextInt();	
	}
	
	public static int serviceRequestMenu(Scanner sc)
	{
		System.out.println("----------Service Request Menu----------");
		System.out.println("0. Exit");
		System.out.println("1. Add new service request");
		System.out.println("2. display specific vehicle service requests");
		System.out.println("Enter your choice: ");
		return sc.nextInt();	
		}
		
	public static int partsMenu(Scanner sc)
		{
			System.out.println("----------Parts Menu----------");
			System.out.println("0. Exit");
			System.out.println("1. Add new part");
			System.out.println("3. Display all parts");
			System.out.println("4. Edit part price");
			System.out.println("5. Delete part");
			System.out.println("Enter your choice: ");
			return sc.nextInt();	
	}
	public static int TodaysbusinessMenu(Scanner sc)
	{
		System.out.println("----------Today's Business Menu----------");
		System.out.println("0. Exit");

		System.out.println("Enter your choice: ");
		return sc.nextInt();	
	}
	public static int givendatesusinessMenu(Scanner sc)
	{
		System.out.println("----------Given Date's Business Menu----------");
		System.out.println("0. Exit");

		System.out.println("Enter your choice: ");
		return sc.nextInt();	
	}
		
}