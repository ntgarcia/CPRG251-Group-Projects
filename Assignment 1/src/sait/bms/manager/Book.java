package sait.bms.manager;

import java.io.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Book {
	String ISBN;
	String callNumber;
	int available;
	int total;
	String title;

	// No-arg constructor
	public Book() {
	}

	public Book(String ISBN, String callNumber, int available, int total, String title) {
		this.ISBN = ISBN;
		this.callNumber = callNumber;
		this.available = available;
		this.total = total;
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", callNumber=" + callNumber + ", available=" + available + ", total=" + total
				+ ", title=" + title + "]";
	}

	/*
	 * CHECKOUT METHOD
	 * ----------------
	 * Implement a method that allows a patron to checkout a book. The user
	 * patron will be prompted to enter the ISBN of a book. If the entered ISBN does
	 * not match, the program will inform the patron with an error message. If the
	 * ISBN matches, the program checks the book’s availability. If there is a book
	 * available, the available count will be decremented and the books information
	 * will be displayed. Otherwise, the user patron will be informed the book is
	 * not available.
	 */

	public static void CheckOut() throws IOException {
		ArrayList<String> list = createList();

		System.out.printf("Enter ISBN of book: ");
		Scanner sc = new Scanner(System.in);
		String ISBN = sc.next();

		char lastChar = ISBN.charAt(ISBN.length() - 1);
		int lastCharInt = Integer.parseInt(String.valueOf(lastChar));

		if (lastCharInt == 0 || lastCharInt == 1) {

			int i = list.indexOf(ISBN);
			String callNumber = list.get(i + 1);
			int available = Integer.parseInt(String.valueOf(list.get(i + 2)));
			int total = Integer.parseInt(String.valueOf(list.get(i + 3)));
			String title = list.get(i + 4);

			System.out.println(ISBN);
			System.out.println(callNumber);
			System.out.println(available);
			System.out.println(total);
			System.out.println(title);
			// 3. use the variables as parameters for the invocation of the book-type
			// constructor

			// ChildrensBook book = new ChildrensBook(ISBN);

		} else if (lastCharInt == 2 || lastCharInt == 3) {
			// invoke the CookBook constructor
			System.out.println("Cook");

		} else if (lastCharInt == 4 || lastCharInt == 5 || lastCharInt == 6 || lastCharInt == 7) {
			// invoke the Paperbacks constructor
			System.out.println("Paper");
		} else if (lastCharInt == 8 || lastCharInt == 9) {
			// invoke the periodicals constructor
			System.out.println("Periodical");
		}
	}

	/*
	 * ARRAYLIST METHOD
	 * ----------------
	 * Implement a method that parses the supplied “books.txt” file into a single
	 * array list. The array list will be able to contain all Book types (cookbooks,
	 * children’s books, and paperbacks). Use the last digit of the ISBN to
	 * determine what a valid type of book needs to be created (see Formatting for
	 * more information).
	 */

	// Populate arraylist with file content
	public static ArrayList<String> createList() throws IOException {
		ArrayList<String> list = new ArrayList<>();
		Scanner fileData;

		File file = new File("..//Assignment 1//res//books.txt");
		fileData = new Scanner(file).useDelimiter(";|\\r\\n");

		while (fileData.hasNext()) {
			list.add(fileData.next());
		}
		return list;

	}

	/*
	 * FINDBOOK METHOD
	 * ----------------
	 * Implement a method that prompts the user patron to enter a title, performs
	 * a case-insensitive search of books that containing the inputted title, and
	 * displays them.
	 */

	public static void FindBook() throws IOException {

	}

	/*
	 * DISPLAYBOOK METHOD
	 * ----------------
	 * Implement a method that prompts the user for a type of book and displays
	 * all books of that type. Down-casting is required to determine the type of
	 * book is what the user specified.
	 */

	public static void DisplayBook() throws IOException {

	}

	/*
	 * RANDOMLIST METHOD
	 * ----------------
	 * Implement a method that prompts a user to enter a number and the program
	 * displays that number of random books. The books can be any type. The
	 * Collections.shuffle method maybe used.
	 */

	public static void RandomList() throws IOException {

		System.out.println("Enter number of books: ");

		// shuffle array
		Collections.shuffle();

	}

	/*
	 * EXIT METHOD
	 * ----------------
	 * Implement and call a method, when the program exits, that takes the books
	 * stored in the array list and persists them back to the “books.txt” file in
	 * the proper format.
	 */

	public static void Exit() throws IOException {

	}

}