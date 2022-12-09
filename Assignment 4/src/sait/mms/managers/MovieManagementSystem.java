package sait.mms.managers;

import java.sql.SQLException;
import java.util.*;

import sait.mms.drivers.MariaDBDriver;

public class MovieManagementSystem {

	public Scanner in;
	private MariaDBDriver driver = new MariaDBDriver();

	public MovieManagementSystem() {
		in = new Scanner(System.in);
		displayMenu();
	}

	public void displayMenu() {

		System.out.println("Jim's Movie Manager");
		System.out.println("1     Add New Movie");
		System.out.println("2     Print movies released in year");
		System.out.println("3     Print random list of movies");
		System.out.println("4     Delete a movie");
		System.out.println("5     Exit");

		System.out.print("\r\nEnter Option: ");
		switch (in.nextInt()) {
			case 1:
				addMovie();
				break;
			case 2:
				printMoviesInYear();
				break;
			case 3:
				printRandomMovies();
				break;
			case 4:
				deleteMovie();
				break;
			case 5:
				System.out.println("\r\nGoodbye!\r\n");
				System.exit(0);
				break;
			default:
				System.out.println("\r\nThat option does not exist! Please select from the available options.\r\n");
				displayMenu();
		}
	}

	private void addMovie() {
		System.out.print("\r\nEnter movie title: ");
		String title = in.next();
		System.out.print("Enter duration: ");
		int duration = in.nextInt();
		System.out.print("Enter year: ");
		String year = in.next();

		String query = "INSERT INTO movies (title, duration, year) VALUES ('" +
				title + "', " +
				duration + ", '" +
				year + "')";

		try {
			driver.update(query);
			System.out.println("Added movie to database\r\n");
			driver.disconnect();
			displayMenu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			displayMenu();
		}
	}

	private void printMoviesInYear() {
		System.out.print("\r\nEnter Movie Year: ");
		int year = in.nextInt();
		
		String queryString = "Select * from movies where year =" +year;
		
		try {
			driver.get(queryString);
			driver.disconnect();
			displayMenu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void printRandomMovies() {
		System.out.print("\r\nEnter number of movies: ");
		int numMovies = in.nextInt();

		String query = "SELECT Duration, Year, Title "
				+ "FROM movies ORDER BY RAND() LIMIT " + numMovies;

		try {
			driver.get(query);
			driver.disconnect();
			displayMenu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			displayMenu();
		}
	}

	private void deleteMovie() {
		System.out.print("\r\nEnter the movie ID that you want to delete: ");
		int id = in.nextInt();

		String query = "DELETE FROM movies WHERE id = '" + id + "'";

		try {
			driver.update(query);
			System.out.println("\r\nMovie " + id + " is deleted.\r\n");
			driver.disconnect();
			displayMenu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			displayMenu();
		}
	}
}
