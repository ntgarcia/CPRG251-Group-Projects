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

}