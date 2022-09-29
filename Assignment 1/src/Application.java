import java.io.*;
import java.util.*;
//9791111299254

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
			CheckOut();
		}
	}
		
	public static void CheckOut() throws IOException {
		ArrayList<String> list = createList();
		
		System.out.printf("Enter ISBN of book: ");
		Scanner sc = new Scanner(System.in);
		String ISBN = sc.next();
		
		char lastChar = ISBN.charAt(ISBN.length() - 1);
		int lastCharInt = Integer.parseInt(String.valueOf(lastChar));
		
		if (lastCharInt == 0 || lastCharInt == 1 ) {
			
			int i = list.indexOf(ISBN);
			String callNumber = list.get(i+1);
			int available = Integer.parseInt(String.valueOf(list.get(i+2)));
			int total = Integer.parseInt(String.valueOf(list.get(i+3)));
			String title = list.get(i+4);
			
			System.out.println(ISBN);
			System.out.println(callNumber);
			System.out.println(available);
			System.out.println(total);
			System.out.println(title);
			// 3. use the variables as parameters for the invocation of the book-type constructor
			
			//ChildrensBook book = new ChildrensBook(ISBN);
			
		} else if (lastCharInt == 2 || lastCharInt == 3) {
			// invoke the CookBook constructor
			System.out.println("Cook");
			
		} else if (lastCharInt == 4 || lastCharInt == 5 || lastCharInt == 6 || lastCharInt == 7 ) {
			// invoke the Paperbacks constructor
			System.out.println("Paper");
		} else if (lastCharInt == 8 || lastCharInt == 9) {
			// invoke the periodicals constructor
			System.out.println("Periodical");
		}
	}
	
	
	//Populate arraylist with file content
	public static ArrayList<String> createList() throws IOException {
		ArrayList<String> list = new ArrayList<>();
		Scanner fileData;
		
		File file = new File("C:\\Users\\Piriya\\Desktop\\SAIT\\Semester 2\\Object\\Assignment\\Assignment 1\\books.txt");
		fileData = new Scanner(file).useDelimiter(";|\\r\\n");
	    
		while (fileData.hasNext()) {
			list.add(fileData.next());
		} 
	    return list;
	    
	}

}
