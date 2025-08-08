package com.practice.miniProjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
	
	public static void main(String[] args) {
		
		Library lib = new Library();		
		lib.showMenu();		
	}
}

//class
//Library
class Library {

	public static List<Book> availableBookList;
	
	
	public Library(){
		availableBookList = new ArrayList<Book>();
		availableBookList.add(new Book("Ponniyin Selvan", "Kalki", 2002, true));
		availableBookList.add(new Book("Pannaiyaarum Padminiyum", "VJs", 2010, true));
		availableBookList.add(new Book("Harry Potter", "James Vasanthan", 1970, true));
		availableBookList.add(new Book("Digital Electonics", "Potum Kuin", 1990, true));
		availableBookList.add(new Book("Compliler Design", "KUngu Koili", 1890, true));			
	}
	
	public void showMenu() {
		
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println(" **** Library Menu **** ");
			System.out.println("1. Add Book");
			System.out.println("2. View Books");
			System.out.println("3. Issue Book");
			System.out.println("4. Return Book");
			System.out.println("5. Exit");
			System.out.println("\n Enter the option to continue..");

			int input = sc.nextInt();
			sc.nextLine();

			switch (input) {

			case 1:
				this.addBook();
				break;
			case 2:
				this.viewBooks();
				break;
			case 3:
				System.out.println("Available BookList is ::: " + availableBookList);
				this.issueBook(availableBookList);
				break;
			case 4:
				this.returnBook(availableBookList);
				break;
			case 5:
				System.exit(0);
				break;
			default:
				break;
			}

		}
	}


	// 1. adding new book to library
	public void addBook() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the name of the book ::: ");
		String bukname = sc.nextLine();

		System.out.println("Enter the author name ::: ");
		String author = sc.nextLine();

		System.out.println("Enter the published year ::: ");
		int pubYear = sc.nextInt();

		System.out.println("Enter the availbility of the book ::: (Y/N) ");
		boolean avail = sc.nextBoolean();

		//List<Book> buklist = new ArrayList<Book>();
		Book buk = new Book(bukname, author, pubYear, avail);
		//buklist.add(buk);
		availableBookList.add(buk);
		System.out.println("Book added successfully...!");

	}
	
	
	// 2. viewing books in library
		public void viewBooks() {
			List<Book> displayBooks = Library.availableBookList;
			for(Book buk : displayBooks) {
				System.out.println(buk);
			}
		}


	// 3. issuing book from library
	public void issueBook(List<Book> availBookList) {

//		Library lib1 = new Library();
//		List<Book> availBookList = lib1.availableBookList();

		System.out.println("Enter the title of the book you want to issue ::: ");
		
		Scanner sc = new Scanner(System.in);
		String userInputTitle = sc.nextLine() ; 
		System.out.println("Title of the book is :::: " + userInputTitle);
		System.out.println("Finding results....");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		boolean found = false;
		
		for(Book book : availBookList) {
			
			if(book.title.equalsIgnoreCase(userInputTitle) && book.available)  {
				found = true;
				book.available = false;
				System.out.println("Yes, Book issued successfully...! ");
				break;
			}
		}
		if(!found)
		System.out.println("No, Book not found..already issued!");
	}

	
	
	// 4. returning book to library
	public void returnBook(List<Book> availBookList) {

		System.out.println("Enter the book that you want to return :::: ");
		Scanner sc = new Scanner(System.in);
		String returningBook  = sc.nextLine();
		
		boolean found = false;
		
		for (Book buk : availBookList) {
			if (buk.title.equalsIgnoreCase(returningBook)) {
				found = true;

				if (buk.available == false) {
					buk.available = true;
					System.out.println("Book returned succesfully!");
				}

				else {
					System.out.println("Book already there in Library!");
				}

				break;
			}
		}
		
	if(!found) {
		System.out.println("Book not found in library...!");
	}

	}
	
	
}   //END LIBRARY CLASS //

//class
//Book
class Book {

	String title;
	String author;
	int publishedYear;
	boolean available;

	public Book(String Title, String Author, int PublishedYear, Boolean Availability) {
		this.title = Title;
		this.author = Author;
		this.publishedYear = PublishedYear;
		this.available = Availability;
	}

	public Book(String returningBook, boolean b) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "" + " Title : " + title + "\n" + " Author : " + author + "\n" + " Published_Year : " + publishedYear
				+ "\n" + " Availablity : " + available + "\n";
	}
}
