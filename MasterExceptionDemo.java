package com.practice.java8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExceptionsPractice {

	public static void main(String[] args) {
		
		ExceptionsPractice ep = new ExceptionsPractice();
		ep.calculateAveragePrice(10000, 0);
		ep.printingStuObj();
		ep.accessInvalidArrayIndex();
		ep.accessInvalidStringIndex();
		ep.convertInvalidStringToInt();
		ep.invalidTypeCasting();
		ep.withdrawAmount();
		ep.readClosedScanner();
		ep.immutableListDemo();
		ep.invalidInputMismatch();
		ep.negativeArraySizeDemo();
		ep.concurrentModificationDemo();
		ep.writeToRestrictedFile();
		ep.openNonExistentFile();
		ep.connectWithInvalidCredentials();
		ep.parseExceptionDemo();
		ep.interruptedExceptionDemo();
		ep.classNotFoundDemo();
		ep.reflectionDemo();
		ep.instantiationExceptionDemo();
		ep.noSuchFieldDemo();
		ep.urlDemo();

	}

//I - RUNTIME EXCEPTIONS (UNCHECKED EXCEPTIONS)

//1. java.lang.ArithmeticException
	/*
	 * Write a method calculateAveragePrice(totalAmount, itemCount) that divides
	 * totalAmount by itemCount. Test it by passing itemCount = 0 and handle the
	 * exception gracefully.
	 */
	
	public void calculateAveragePrice(int totalAmount, int itemCount) {

		try {
			int price = totalAmount / itemCount;
			System.out.println("Average Price is ::: " + price);
		} catch (ArithmeticException e) {
			System.out.println("Can't divide by zero...!");
			e.printStackTrace();  ///log the exception
		}
	}
	
	
//2. java.lang.NullPointerException
	/*
	 * Create a Student class with a name field. In main, set the student object to
	 * null and try to print name.length()
	 */
	public void printingStuObj() {		
		Student stu = null;
		System.out.println(stu.name.length());
	}
	
	
	
//3. java.lang.ArrayIndexOutOfBoundsException
	/* Create an array of 5 integers. Try to print the element at index 10. */
	
	public void accessInvalidArrayIndex() {
		try {
			int[] arr = { 6, 8, 9, 1, 0 };
			System.out.println(arr[10]);
		} catch (Exception e) {
			System.out.println("Invalid index access ::: " + e.getMessage());
		}
	}
	

	
//4. java.lang.StringIndexOutOfBoundsException
	/*
	 * Write a program that reads a string from the user and prints its first
	 * character. Test it with an empty string.
	 */

	public void accessInvalidStringIndex() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String :::: ");
		try {
			String input = sc.nextLine();
			char first = input.charAt(0);
			System.out.println("First character ::: " + first);
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Entered String is empty. Cannot access first character!");
			e.printStackTrace();
		}

	}

	
	
//5.java.lang.NumberFormatException
	/* Take a string "abc123" and try converting it to an integer */

	public void convertInvalidStringToInt() {
		String input = "abc123";
		try {
			int n = Integer.parseInt(input);
			System.out.println("Parsed integer string is ::: " + n);
		} catch (NumberFormatException ne) {
			System.out.println("Error : " + input + " not a valid String!");
			ne.printStackTrace();
		}
	}
	


//6.java.lang.ClassCastException
	/* Create an Object variable storing an Integer. Try casting it to a String */

	public void invalidTypeCasting() {
		try {
			Object obj = Integer.valueOf(42);
			String str = (String) obj;
			System.out.println(str);
		} catch (ClassCastException e) {
			System.out.println("Invalid type casting: " + e.getMessage());
		}

	}
	
	
//7. java.lang.IllegalArgumentException
	/*Write a method withdraw(amount) that throws IllegalArgumentException 
	 if the amount is negative. Call it with -100.*/

	public void withdrawAmount() {
		try {
			withdraw(-100);
		} catch (IllegalArgumentException e) {
			System.out.println("Error ::: " + e.getMessage());
		}
	}
		
	public void withdraw(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Withdrawal amount cannot be negative..!");
		}
		System.out.println("Withdrawing ::: " + amount);
	}
	
	
	
// 8.java.lang.IllegalStateException
	/*Create a Scanner to read a file, close it, and then try reading again.*/
	
	public void readClosedScanner() {
		try {
			File file = new File("E:\\new.txt");
			if (!file.exists()) {
				System.out.println("File not found..!" + file.getAbsolutePath());
				return;
			}
			Scanner sc = new Scanner(file);
			if (sc.hasNextLine()) {
				System.out.println("First line ::: " + sc.nextLine());
			}
			sc.close();
			System.out.println("After closing scanner file ::: " + sc.nextLine());
		} catch (FileNotFoundException fe) {
			System.out.println("File not found: " + fe.getMessage());
		} catch (IllegalStateException e) {
			System.out.println("Scanner already closed: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
//9. java.lang.UnsupportedOperationException
	/*Create an immutable list using List.of() (jdk9 feature) and try adding a new element.
	using jdk8 only so used collections feature here */
	
	public void immutableListDemo() {
		try {
			List<String> mutable = Arrays.asList("Sumathi", "Malathi", "Karthi");
			List<String> immutableNames = Collections.unmodifiableList(mutable);
			System.out.println("Originla list is ::: " + immutableNames);
			immutableNames.add("Jawahar");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify immutable list: " + e.getMessage());
			e.printStackTrace();
		}
	}


	
//10. java.util.InputMismatchException
	/*Use Scanner to read an integer but type "hello" instead.*/
	public void invalidInputMismatch() {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the no ::: ");
			int no = sc.nextInt();
			System.out.println("You entered ::: " + no);
		} catch (InputMismatchException e) {
			System.out.println("Invalid input, please enter an integer only! ");
			e.printStackTrace();
		}
	}
	

	
//11. java.lang.NegativeArraySizeException
	// Try creating an array with size -5
	public void negativeArraySizeDemo() {
		try {
			int[] arr = new int[-5];
		} catch (NegativeArraySizeException e) {
			System.out.println("Array size cannot be neagtive!");
			e.printStackTrace();
		}
	}
	
	
	
 //12. java.util.ConcurrentModificationException
	/*Modify a list while iterating with for-each*/
	
	public void concurrentModificationDemo() {
		try {
			List<Integer> list = new ArrayList<Integer>();
			list.add(10);
			list.add(20);
			list.add(100);
			for (Integer no : list) {
				list.remove(0);
			}
		} catch (ConcurrentModificationException e) {
			System.out.println("Concurrent modification not allowed: " + e);
		}
	}
	
	
	//II - CHECKED EXCEPTIONS
	//13. IOException
	/*Try writing to a file in a directory where you don’t have write permission.*/
	
	public void writeToRestrictedFile() {

		FileWriter writer = null;
		try {
			writer = new FileWriter("C:\\Windows\\System32\\restricted.txt");
			writer.write("Hello, restricted world! ");
			System.out.println("Write successful!");
		} catch (Exception e) {
			System.out.println("Exception occured! " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				System.out.println("Error closing writer :: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

		
	// java.io.FileNotFoundException
	/* 14. Try opening a file named "data123.txt" that doesn’t exist. */

	public void openNonExistentFile() {
		try {
			File reader = new File("D:\\new.txt");
			Scanner sc = new Scanner(reader);
			System.out.println(sc.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	//java.sql.SQLException
	/*15. Try connecting to a database with incorrect credentials.*/
	
	public void connectWithInvalidCredentials() {

		String user = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "wrongUser";
		String password = "wrongPassword";
		
		try {
			Connection conn = DriverManager.getConnection(user, username, password);
			System.out.println("Connected Successfully:: " + conn);
			conn.close();
		}
		catch(SQLException e) {
			System.out.println("Connection failed!");
			e.printStackTrace();
		}
	}
	
	
	// java.text.ParseException
	/* 16. Use SimpleDateFormat to parse "31-02-2023" with format dd-MM-yyyy. */

	public void parseExceptionDemo() {

		String value = "31-02-2023";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			formatter.setLenient(false);
			Date date = formatter.parse(value);
			String dtae = formatter.format(date);
			System.out.println("Date is ::: " + dtae);

		} catch (ParseException e) {
			System.out.println("Invalid date format: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	//java.lang.InterruptedException
	/*17. Start a thread that sleeps for 10 seconds, then interrupt it from another thread.*/
	
	public void interruptedExceptionDemo() {

		Thread sleeper = new Thread();
		try {
			System.out.println("Sleeper thread satrted, going to sleep for 10 seconds !");
			sleeper.sleep(1000);
	        System.out.println("Sleeper thread woke up normally.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Sleeper thread interuptted successfully !");
			e.printStackTrace();
		}

	}
	
	
	//java.lang.ClassNotFoundException
	/* 18. Use Class.forName("non.existing.ClassName"). */

	public void classNotFoundDemo() {
		try {
			Class.forName("come.practice.Demo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//java.lang.InstantiationException
	/*19. Try creating an object of an abstract class using Class.forName(...).newInstance()*/
	
	public void instantiationExceptionDemo() {
	    try {
	        Class<?> clazz = Class.forName("com.practice.java8.MyAbstractClass");
	        Object obj = clazz.newInstance(); // will throw InstantiationException
	        System.out.println("Object created: " + obj);
	    } catch (ClassNotFoundException e) {
	        System.out.println("Class not found: " + e.getMessage());
	    } catch (InstantiationException e) {
	        System.out.println("Cannot instantiate abstract class: " + e.getMessage());
	    } catch (IllegalAccessException e) {
	        System.out.println("Illegal access: " + e.getMessage());
	    }
	}
	

	
	//java.lang.reflect.NoSuchMethodException
	/*20. Use reflection to call a non-existent method on a class.*/

	public void reflectionDemo() {
		try {
			Method method = String.class.getMethod("nonExistent");
			method.invoke("Hello");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//21. java.lang.reflect.NoSuchFieldException
	/*Use reflection to access a non-existent field in a class.*/
	
	public void noSuchFieldDemo() {
		try {
			Field field = String.class.getField("nonExistent");
			field.get("Hello");
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	//MalformedURLException
	/*22. Try creating a URL with "htp:/example".*/
	
	public void urlDemo() {

		try {
			URL url = new URL("htp:/exacmple");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Caught MalformedURLException: " + e.getMessage());
			e.printStackTrace();
		}
	}
}



//created for 2nd problem
class Student {

	String name;
	
	public Student(String stuName) {
		this.name = stuName;
	}	
}