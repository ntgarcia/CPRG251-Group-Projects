package sait.bms.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import sait.bms.problemdomain.*;

public class BookManager extends Book {
	public Scanner in;
	// attributes
	public ArrayList<Book> books;

	public BookManager() throws IOException {
		books = new ArrayList<>();
		loadBooksFromFile();
		in = new Scanner(System.in);

		printMenu();

	}

	private void loadBooksFromFile() throws FileNotFoundException {
		Scanner in = new Scanner(new File("res/books.txt"));
		while (in.hasNext()) {
			String line = in.nextLine();
			String[] fields = line.split(";");
			int lastDigit = Integer.parseInt(fields[0].substring(12));
			Book book = null;
			if (lastDigit == 0 || lastDigit == 1) {
				book = new Childrens_books(fields[0], fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], fields[6]);
			} else if (lastDigit == 2 || lastDigit == 3) {
				book = new Cookbooks(fields[0], fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]),
						fields[4], fields[5], fields[6]);
			} else if (lastDigit >= 4 && lastDigit <= 7) {
				book = new Paperbacks(fields[0], fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]),
						fields[4], fields[5], Integer.parseInt(fields[6]), fields[7]);
			} else if (lastDigit == 8 || lastDigit == 9) {
				book = new Periodicals(fields[0], fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]),
						fields[4], fields[5]);
			}
			// System.out.println(book);
			books.add(book);
		}
		in.close();
	}

	public void printMenu() throws IOException {

		System.out.println("Welcome in ABC Book Company: How May We Assist You?");
		System.out.println("1     Checkout Book");
		System.out.println("2     Find Books by Title");
		System.out.println("3     Display Books by Type");
		System.out.println("4     Produce Random Book List");
		System.out.println("5     Save & Exit");

		System.out.print("\r\nEnter Option: ");
		switch (in.nextInt()) {
			case 1:
				checkOut();
			case 2:
				findBookByTitle();
			case 3:
				displayBookByType();
			case 4:
				produceRandomBookList();
			case 5:
				// saveAndExit();
		}

	}

	private void checkOut() throws IOException {
		int count = 0;
		System.out.print("Please enter the ISBN number: ");
		String userISBN = in.next();
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			if (userISBN.equals(book.getIsbn()) && book.getAvailable() > 0) {
				System.out.println("\r\nThe book \"" + book.getTitle() + "\" has been checked out");
				System.out.println("It can be located using a call number: " + book.getCallNumber() + "\r\n");
				book.setAvailable(book.getAvailable() - 1);
				count++;
			}
			if (userISBN.equals(book.getIsbn()) && book.getAvailable() == 0) {
				System.out.println("\r\nThe book is not in inventory.\r\n");
				count++;
			}
		}
		// The if statement is used to display an error message when
		// the ISBN couldn't be matched and count remains 0
		if (count == 0) {
			System.out.println("\r\nThe provided ISBN doesn't match any book in the system.\r\n");
		}
		printMenu();
	}

	private void findBookByTitle() throws IOException {
		int count = 0;
		System.out.print("Enter title to search for: ");
		String title = in.next();
		System.out.println("Matching books");
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				if (book instanceof Cookbooks) {
					System.out.println(books.get(i));
					count++;
				} else if (book instanceof Childrens_books) {
					System.out.println(books.get(i));
					count++;
				} else if (book instanceof Paperbacks) {
					System.out.println(books.get(i));
					count++;
				} else if (book instanceof Periodicals) {
					System.out.println(books.get(i));
					count++;
				}
			}
		}
		if (count == 0) {
			System.out.println("\r\nThere is no matching book for this title.\r\n");
		}
		printMenu();
	}

	private void displayBookByType() throws IOException {
		System.out.println("#     Type");
		System.out.println("1     Children's Books");
		System.out.println("2     Cookbooks");
		System.out.println("3     Paperbacks");
		System.out.println("4     Periodicals");

		System.out.println("Enter type of book: ");

		switch (in.nextInt()) {
			// children books
			case 1:
				System.out.println("Enter a format (P for Picture book, E for Early Readers, C for Chapter book):");
				for (int i = 0; i < books.size(); i++) {
					Book book = books.get(i);

					if (book instanceof Childrens_books) {
					    System.out.println(books.get(i));
						if (Childrens_books.getFormat().equals(in.nextLine())) {
							System.out.println(books.get(i));
						}
					}
				}

				// cookbooks
			case 2:
				System.out.println(
						"Enter a diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None):");
				for (int i = 0; i < books.size(); i++) {
					Book book = books.get(i);
					if (book instanceof Cookbooks) {
						if (Cookbooks.getDiet().equals(in.nextLine())) {
							System.out.println(books.get(i));
						}
					}
				}

				// paperbacks
			case 3:
				System.out.println(
						"Enter a genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction):");
				for (int i = 0; i < books.size(); i++) {
					Book book = books.get(i);
					if (book instanceof Paperbacks) {
						if (Paperbacks.getGenre().equals(in.nextLine())) {
							System.out.println(books.get(i));
						}
					}
				}

				// periodicals
			case 4:
				System.out.println(
						"Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly, or Q for Quarterly):");
				for (int i = 0; i < books.size(); i++) {
					Book book = books.get(i);
					if (book instanceof Periodicals) {
						if (Periodicals.getFrequency().equals(in.nextLine())) {
							System.out.println(books.get(i));
						}
					}
				}

		}
	}

	private void produceRandomBookList() throws IOException {
		System.out.print("Enter number of books: ");
		// shuffle list, then pick first n number
		int numberOfBooks = in.nextInt();
		Collections.shuffle(books);
		System.out.println("\r\nRandom books");

		// while loop: make counter equal i. while counter i not equal to zero, print a
		// book, and then --
		while (numberOfBooks != 0) {
			if (books.get(numberOfBooks) instanceof Cookbooks) {
				System.out.println(books.get(numberOfBooks));
			} else if (books.get(numberOfBooks) instanceof Childrens_books) {
				System.out.println(books.get(numberOfBooks));
			} else if (books.get(numberOfBooks) instanceof Paperbacks) {
				System.out.println(books.get(numberOfBooks));
			} else if (books.get(numberOfBooks) instanceof Periodicals) {
				System.out.println(books.get(numberOfBooks));
			}
			numberOfBooks--;
		}
		printMenu();
	}
}

// private String checkOut() {
// // get isbn
//
// System.out.println("Enter ISBN of book: ");
//
// // check isbn inside books
// // if isbn does not exist, print error
// if (books.contains(isbn_input)) {
// // check availability
// if (check_book.getAvailable() > 0) {
// // update availability -1,
// System.out.println("The book " + check_book.getTitle() + "has been checked
// out.");
// System.out.println("It can be located using call number: " +
// check_book.getCallNumber());
// } else {
// // if not available print msg
// System.out.println("The book is not available.");
// }
// } else {
// // print error message
// System.out.println("Error: ISBN does not exist.");
// }
//
// }

// private String findBooks() {
// System.out.println("Enter title to search for: ");
// // case sensitive
// // use for loop to find each title
// for () {
// // should be a to string, since were using this for the next method too
// System.out.println("Matching Books:");
// System.out.println("ISBN: " + getIsbn());
// System.out.println("Call Number: " + getCallNumber());
// System.out.println("Available: " + getAvailable());
// System.out.println("Total: " + getTotal());
// System.out.println("Title: " + getTitle());
// // check type for extra param print
// if (book == Childrens_books) {
// System.out.println("Authors: " + getAuthors());
// System.out.println("Format: " + getFormat());
// } else if (book == Cookbooks) {
//
// } else if (book == Paperbacks) {
//
// } else {
// // periodicals
// }
// }
// }
//
// private String dispayBooks() {
// System.out.println("# Type");
// System.out.println("1 Children's Books");
// System.out.println("2 Cookbooks");
// System.out.println("3 Paperbacks");
// System.out.println("4 Periodicals");
//
// System.out.println("Enter type of book: ");
// // need downcasting
//
// if (type == 4) {
// System.out.println(
// "Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly,
// or Q for Quarterly): ");
// } else {
//
// }
//
// }
//
//
// private String saveExit() {
// // save changes to .txt?
// System.out.println("Goodbye");
// }

/*
 * private Wage getHighestPaidWageEmployee() {
 * Wage wage = null;
 * double highestPay = 0;
 * 
 * for (int i = 0; i < employees.size(); i++) {
 * Employee employee = employees.get(i);
 * if (employee instanceof Wage) {
 * if (employee.getPay() > highestPay) {
 * highestPay = employee.getPay();
 * wage = (Wage) employee;
 * }
 * }
 * }
 * return wage;
 * }
 * 
 * private Salaried getLowestPaidSalariedEmployee() {
 * Salaried salaried = null;
 * double lowestPay = 0;
 * boolean first = true;
 * for (int i = 0; i < employees.size(); i++) {
 * Employee employee = employees.get(i);
 * if (employee instanceof Salaried) {
 * if (first) {
 * lowestPay = employee.getPay();
 * first = false;
 * }
 * if (employee.getPay() <= lowestPay) {
 * lowestPay = employee.getPay();
 * salaried = (Salaried) employee;
 * }
 * }
 * }
 * return salaried;
 * }
 * 
 * private double getEmployeePercentage(String type) {
 * int count = 0;
 * 
 * switch (type) {
 * case "PartTime":
 * for (Employee emp : employees) {
 * if (emp instanceof PartTime) {
 * count++;
 * }
 * 
 * }
 * break;
 * 
 * case "Wage":
 * for (Employee emp : employees) {
 * if (emp instanceof Wage) {
 * count++;
 * }
 * 
 * }
 * break;
 * 
 * case "Salaried":
 * for (Employee emp : employees) {
 * if (emp instanceof Salaried) {
 * count++;
 * }
 * 
 * }
 * break;
 * }
 * return 100.0 * count / employees.size();
 * }
 */
