package sait.bms.application;

import java.io.*;
import java.util.*;
//9791111299254

import sait.bms.manager.Book;
import sait.bms.problemdomain.ChildrensBook;

public class Application {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.printf("Welcome to ABC Book Company: How May We Assist You?\r\n" +
				"1	Checkout Book%n" +
				"2	Find Books by Title\r\n" +
				"3	Display Books by Type\r\n" +
				"4	Produce Random Book List\r\n" +
				"5	Save & Exit\r\n" +
				"");

		System.out.printf("Enter option: ");
		Scanner sc = new Scanner(System.in);
		int input1 = sc.nextInt();

		if (input1 == 1) {
			Book.CheckOut();
		}
	}

}
