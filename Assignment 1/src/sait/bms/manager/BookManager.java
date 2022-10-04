package sait.bms.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Writer;
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
				saveAndExit();
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
				String inFormat = in.next().toUpperCase();
				for (Book child : books) {
					if (child instanceof Childrens_books) {
						if (((Childrens_books) child).getFormat().equals(inFormat)) {
							System.out.println(((Childrens_books) child).printChild());
						}
					}
				}
				printMenu();
				break;

			// cookbooks
			case 2:
				System.out.println(
						"Enter a diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None):");
				String inDiet = in.next().toUpperCase();
				for (Book cook : books) {
					if (cook instanceof Cookbooks) {
						if (((Cookbooks) cook).getDiet().equals(inDiet)) {
							System.out.println(((Cookbooks) cook).printCook());
						}
					}
				}
				printMenu();
				break;

			// paperbacks
			case 3:
				System.out.println(
						"Enter a genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction):");
				String inGenre = in.next().toUpperCase();
				for (Book paper : books) {
					if (paper instanceof Paperbacks) {
						if (((Paperbacks) paper).getGenre().equals(inGenre)) {
							System.out.println(((Paperbacks) paper).printPaper());
						}
					}
				}
				printMenu();
				break;

			// periodicals
			case 4:
				System.out.println(
						"Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly, or Q for Quarterly):");
				String inFrequency = in.next().toUpperCase();
				for (Book period : books) {
					if (period instanceof Periodicals) {
						if (((Periodicals) period).getFrequency().equals(inFrequency)) {
							System.out.println(((Periodicals) period).printPeriod());
						}
					}
				}
				printMenu();
				break;
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

	public void saveAndExit() throws IOException {
		boolean flag = true;
		if (flag == true) {
			try (Writer instream = new FileWriter("res/books.txt", false)) {
				for (Book entry : books)
					instream.write(entry + "\n");
			} catch (IOException e) {
				System.out.println("The file could not be written to!");
			}
		}
	}
}
