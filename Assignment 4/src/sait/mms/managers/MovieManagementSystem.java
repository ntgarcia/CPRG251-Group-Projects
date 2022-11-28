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
			case 2:
				printMoviesInYear();
			case 3:
				printRandomMovies();
			case 4:
				deleteMovie();
			case 5:
				System.out.println("Goodbye!");
				System.exit(0);
		}
	}

	private void addMovie() {
		System.out.print("Enter movie title: ");
		String title = in.next();
		System.out.print("Enter duration: ");
		int duration = in.nextInt();
		in.next();
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

	}

	private void printRandomMovies() {
		System.out.print("Enter number of movies: ");
		int numMovies = in.nextInt();

		String query = "SELECT * FROM movies ORDER BY RAND() LIMIT " + numMovies;

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
		System.out.print("Enter the movie ID that you want to delete: ");
		int id = in.nextInt();

		String query = "DELETE FROM movies WHERE id = '" + id + "'";

		try {
			driver.update(query);
			System.out.println("Movie " + id + " is deleted.\r\n");
			driver.disconnect();
			displayMenu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			displayMenu();
		}
	}
}
