package sait.bms.manager;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.*;

import sait.bms.problemdomain.*;

public class BookManager {
	
}

	// attributes
	ArrayList<BookManager> books;

	public BookManager() throws FileNotFoundException {

		loadBooksFromFile();
		System.out.println("Welcome in ABC Book Company: How May We Assist You?");
		System.out.println("1     Checkout Book");
		System.out.println("2     Find Books by Title");
		System.out.println("3     Display Books by Type");
		System.out.println("4     Produce Random Book List");
		System.out.println("5     Save & Exit");

		System.out.println("Enter Option: ");

		Switch(option) {
			case "1":
				checkOut();
			case "2":
				findBooks();
			case "3":
				displayBooks();
			case "4":
				randomBooks();
			case "5":
				saveExit();
		}
	}

	private void loadBooksFromFile() throws FileNotFoundException {
		books = new ArrayList<>();
		Scanner in = new Scanner(new File("res/books.txt"));
		while (in.hasNext()) {
			String line = in.nextLine();
			String[] fields = line.split(":");
			int lastDigit = Integer.parseInt(fields[12].substring(0, 1));
			Book book = null;
			if (lastDigit == 0 || lastDigit == 1) {
				book = new Childrens_books(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
			} else if (lastDigit == 2 || lastDigit == 3) {
				book = new Cook_books(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]);
			} else if (lastDigit == 4 || lastDigit == 7) {
				book = new Paperbacks(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6],
						fields[7]);
			} else if (lastDigit == 8 || lastDigit == 9) {
				book = new Periodicals(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]);
			}
			books.add(book);
		}
		in.close();

	}

	private String checkOut() {
		// get isbn

		System.out.println("Enter ISBN of book: ");
            long 
		// check isbn inside books
		// if isbn does not exist, print error
		if (books.contains(isbn_input)) {
			// check availability
			if (check_book.getAvailable() > 0) {
				// update availability -1,
				System.out.println("The book " + check_book.getTitle() + "has been checked out.");
				System.out.println("It can be located using call number: " + check_book.getCallNumber());
			} else {
				// if not available print msg
				System.out.println("The book is not available.");
			}
		} else {
			// print error message
			System.out.println("Error: ISBN does not exist.");
		}

	}

	private String findBooks() {
		System.out.println("Enter title to search for: ");
		// case sensitive
		// use for loop to find each title
		for () {
			// should be a to string, since were using this for the next method too
			System.out.println("Matching Books:");
			System.out.println("ISBN: " + getIsbn());
			System.out.println("Call Number: " + getCallNumber());
			System.out.println("Available: " + getAvailable());
			System.out.println("Total: " + getTotal());
			System.out.println("Title: " + getTitle());
			// check type for extra param print
			if (book == Childrens_books) {
				System.out.println("Authors: " + getAuthors());
				System.out.println("Format: " + getFormat());
			} else if (book == Cookbooks) {
				
			} else if (book == Paperbacks) {

			} else {
				// periodicals
			}
		}
	}

	private String dispayBooks() {
		System.out.println("#     Type");
		System.out.println("1     Children's Books");
		System.out.println("2     Cookbooks");
		System.out.println("3     Paperbacks");
		System.out.println("4     Periodicals");

		System.out.println("Enter type of book: ");
		// need downcasting

		if (type == 4) {
			System.out.println(
					"Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly, or Q for Quarterly): ");
		} else {

		}

	}

	private String displayBooks() {
		System.out.println("Enter number of books: ");
		// shuffle list, then pick first n number
		Collections.shuffle(books);
		// while loop: make counter equal i. while counter i not equal to zero, print a book, and then --
		while () {
			
		}
	}

	private String saveExit() {
		// save changes to .txt?
		System.out.println("Goodbye");
	}
