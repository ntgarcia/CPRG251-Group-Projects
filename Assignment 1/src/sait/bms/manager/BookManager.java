package sait.bms.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import sait.bms.problemdomain.*;

public class BookManager {

	// attributes
	ArrayList<BookManager> books;

	public BookManager() throws FileNotFoundException {

		loadBooksFromFile();
		System.out.println("Welcome in ABC Book Company: How May We Assist You?");
		System.out.println("1. Checkout Book");
		System.out.println("2. Find Books by Title");
		System.out.println("3. Display Books by Type");
		System.out.println("4. Produce Random Book List");
		System.out.println("5. Save & Exit");
	}

	private void loadBooksFromFile() throws FileNotFoundException {
		books = new ArrayList<>();
		Scanner in = new Scanner(new File("res/books.txt"));
		while (in.hasNext()) {
			String line = in.nextLine();
			String[] fields = line.split(":");
			int lastDigit = Integer.parseInt(fields[12].substring(0, 1));
			BookManager book = null;
			if (lastDigit >= 0 && lastDigit <= 1) {
				book = new Childrens_books();
			} else if (lastDigit >= 5 && lastDigit <= 7) {
				book = new Cookbooks();
			} else if (lastDigit >= 8 && lastDigit <= 9) {
				book = new Paperbacks();
			} else if (lastDigit >= 8 && lastDigit <= 9) {
				book = new Periodicals();
			}
			books.add(book);
		}
		in.close();

	}

	private double getAveragePay() {
		double sum = 0;
		for (Employee employee : employees) {
			sum += employee.getPay();
		}
		return sum / employees.size();
	}

	private Wage getHighestPaidWageEmployee() {
		Wage wage = null;
		double highestPay = 0;

		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			if (employee instanceof Wage) {
				if (employee.getPay() > highestPay) {
					highestPay = employee.getPay();
					wage = (Wage) employee;
				}
			}
		}
		return wage;
	}

	private Salaried getLowestPaidSalariedEmployee() {
		Salaried salaried = null;
		double lowestPay = 0;
		boolean first = true;
		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			if (employee instanceof Salaried) {
				if (first) {
					lowestPay = employee.getPay();
					first = false;
				}
				if (employee.getPay() <= lowestPay) {
					lowestPay = employee.getPay();
					salaried = (Salaried) employee;
				}
			}
		}
		return salaried;
	}

	private double getEmployeePercentage(String type) {
		int count = 0;

		switch (type) {
			case "PartTime":
				for (Employee emp : employees) {
					if (emp instanceof PartTime) {
						count++;
					}

				}
				break;

			case "Wage":
				for (Employee emp : employees) {
					if (emp instanceof Wage) {
						count++;
					}

				}
				break;

			case "Salaried":
				for (Employee emp : employees) {
					if (emp instanceof Salaried) {
						count++;
					}

				}
				break;
		}
		return 100.0 * count / employees.size();
	}

}