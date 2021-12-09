
// THIS CODE WAS WRITTEN BY DAVE DOMINQUE*********************************************************************************************************

import java.time.LocalDate;
import java.time.Period;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException classto handle errors
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class main {
	
	public static void main(String[] args) {

		
		System.out.println("Fake ID Generator");
		System.out.println("ENTER THE INFORMATION CURRENTLY ON YOUR ID");
		System.out.print("\n");
		
		ID newID = new ID();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Name: ");
		newID.name = scan.nextLine();
		
		int bdaymonth = 0, bdayDay = 0, bdayYear = 0;
		LocalDate today = LocalDate.now();
		System.out.println("Birhtdate----- ");
		
//		System.out.print("Month (01-12) : ");
//		//Scanner myScan1 = new Scanner(System.in);
//		bdaymonth = scan.nextInt();
		
		while(true) {
			try {
				System.out.print("Month (01-12) : ");
				Scanner myScan1 = new Scanner(System.in);
				bdaymonth = myScan1.nextInt();
				
				if(bdaymonth > 12 || bdaymonth < 1) {
					throw new Exception("Invalid month entry");
				}
				break;
				
			}catch(InputMismatchException f) {
				
				System.out.println("Input Mismatch!");
			}catch(Exception e) {
				
				System.out.println(e);
			}
		}
		
		while(true) {
			try {
				System.out.print("Day (01-31): ");
				Scanner myScan2 = new Scanner(System.in);
				bdayDay = myScan2.nextInt();
				
				if(bdayDay > 31 || bdayDay < 1) {
					throw new Exception("Invalid day entry");
				}
				break;
				
			}catch(InputMismatchException f) {
				
				System.out.println("Input Mismatch!");
			}catch(Exception e) {
				
				System.out.println(e);
			}
		}

		while(true) {
			try {
				System.out.print("Year (####) : ");
				Scanner myScan2 = new Scanner(System.in);
				bdayYear = myScan2.nextInt();
				break;
				
			}catch(InputMismatchException f) {
					
					System.out.println("Input Mismatch!");
			}
		}
		
		newID.birthdate = LocalDate.of(bdayYear, bdaymonth, bdayDay);
		
		newID.age = Period.between(newID.birthdate, today).getYears();
		

		while(true) {
			try {
				System.out.print("Sex: ");
				Scanner myScan2 = new Scanner(System.in);
				newID.sex = Character.toUpperCase(myScan2.next().charAt(0));
				
				if(!(newID.sex == 'F' || newID.sex == 'M'))
				{
					throw new Exception("Invalid sex entry");
				}
				
				break;
				
			}catch(InputMismatchException f) {
				
				System.out.println("Input Mismatch!");
			}catch(Exception e) {
				
				System.out.println(e);
			}
		}
		
		
		
		
		
		
//		boolean valid = false;
//		do {
//			System.out.print("Sex: ");
//			newID.sex = Character.toUpperCase(scan.next().charAt(0));
//			
//			if(newID.sex == 'F' || newID.sex == 'M')
//			{
//				valid = true;
//				//System.out.print("right type");
//			}
//			
//			else {
//				System.out.println("Invalid entry, please try again");
//			}
//			
//		}while(!valid);
		
				
		while(true) {
			try {
				System.out.print("Height: (#feet.#inches)");
				Scanner myScan = new Scanner(System.in);
				newID.height = myScan.nextDouble();
				break;
				
			}catch(InputMismatchException e) {
				
				System.out.println("Input Mismatch!");
			}
		}
		
		
		System.out.print("Address: ");
		//scan.nextLine();
		newID.address = scan.nextLine();
		
		
		System.out.println("Expiration date----- ");
		int expmonth=0, expday=0, expYear=0;
		
			while(true) {
				try {
					System.out.print("Month (01-12) : ");
					Scanner myScan3 =  new Scanner(System.in);
					expmonth = myScan3.nextInt();
					
					if(expmonth > 12 || expmonth < 1) {
						throw new Exception("Invalid month entry");
					}
					
					break;
				}catch(InputMismatchException f) {
					System.out.println("Input Mismatch!");
					
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			
			while(true) {
				try {
					System.out.print("Day (01-31): ");
					Scanner myScan4 = new Scanner(System.in);
					expday = myScan4.nextInt();
					
					if(expday > 31 || expday < 1) {
						throw new Exception("Invalid day entry");
					}
					break;
					
				}catch(InputMismatchException f) {
					
					System.out.println("Input Mismatch!");
				}catch(Exception e) {
					
					System.out.println(e);
				}
			}
				
			while(true) {
				try {
					System.out.print("Year (####) : ");
					Scanner myScan2 = new Scanner(System.in);
					expYear = myScan2.nextInt();
					
					if(expYear < 2021) {
						throw new Exception("Invalid year entry");
					}
					
					break;
					
				}catch(InputMismatchException f) {
					
					System.out.println("Input Mismatch!");
				}catch(Exception e) {
					
					System.out.println(e);
				}
			}
			
			
		newID.expirationdate = LocalDate.of(expYear, expmonth, expday);
		
		
		System.out.print("\n\n");
		
		System.out.println("Here is your Original ID:\n");
		System.out.print(newID);
		System.out.print("\n\n");
		
		fakeID newFake = new fakeID(newID.name, newID.age, newID.sex, newID.birthdate, newID.expirationdate, newID.height, newID.address);
		
		System.out.println("Here is your fake:\n");

		System.out.print(newFake);
		
	}	
}		

class ID 
{
	String name; //webscraping api (baby names)
	int age;
	char sex;
	double height;
	String address;
	LocalDate birthdate;// = LocalDate.of(2002,12,20);
	LocalDate expirationdate;// = LocalDate.of(2021,12,12);

	public ID()
	{
		this.name = null;
		this.age = 0;
		this.sex = 'F';
		this.height = 0.0;
		this.address = null;
		this.birthdate = LocalDate.of(0000,01,01);
		this.expirationdate = LocalDate.of(0000,01,01);
		
		//try deleting all the them to see what happens
	}
	
	public String toString()
	{
		return "Name: " + name +"\n"+ "Age: " + age  +"\n"+ "Height: " + height +"\n"+ "Address: " + address +"\n"+ "Birthdate: " + birthdate +"\n"+ "Expiration Date: " + expirationdate;
	}
	
	
}

class fakeID {
	
	String fake_name;
	int fake_age;
	char same_sex;
	LocalDate fake_bday;
	LocalDate fake_exp;
	double fake_height;
	String fake_address;
	
	String newName(char sex) {
				
		String fakeName = "";
		
		String firstNamesMen[] = {"Liam", "Noah",	"Oliver","Elijah" ,
				"William", "James",	"Benjamin",	"Lucas", "Henry", "Alexander"};
				
		String firstNamewmn[] = {"Olivia", "Emma", "Ava" ,"Charlotte",
				"Sophia", "Amelia" ,"Isabella", "Mia", "Evelyn", "Harper"};
		
		String lastName[] = { "Smith", "Johnson", "Williams", "Brown", 
				"Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez" } ;
		
		if(sex == 'F')
		{
			fakeName = firstNamewmn[new Random().nextInt(firstNamewmn.length)] + " " + lastName[new Random().nextInt(lastName.length)];
		}
		
		else {
			fakeName = firstNamesMen[new Random().nextInt(firstNamesMen.length)] + " " + lastName[new Random().nextInt(lastName.length)];
		}
		
		return fakeName;
	}
	
	
	
	public fakeID(String name, int age, char sex, LocalDate bday, LocalDate exp, double height, String Address) {
		
		this.fake_name = newName(sex);// think about how you want to make a new name ot this 
		this.fake_age = age += 3;
		fake_bday = LocalDate.of( bday.getYear()-3, bday.getMonthValue(), bday.getDayOfMonth());
		fake_exp = LocalDate.of( exp.getYear(), exp.getMonthValue(), exp.getDayOfMonth());
		this.fake_height = height;
		this.fake_address = Address;
		
	}
	
	public String toString()
	{
		
		return "Name: " + fake_name +"\n"+ "Age: " + fake_age  +"\n"+ "Height: " + fake_height +"\n"+ "Address: " + fake_address +"\n"+ "Birthdate: " + fake_bday +"\n"+ "Expiration Date: " + fake_exp;

	}
	
	
	
	
	
}
