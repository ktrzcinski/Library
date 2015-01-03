package app;

import data.Book;
import data.Library;
import utils.DataReader;

public class LibraryControl {

	// variables do control the program
	public final int EXIT = 0;
	public final int ADD_BOOK = 1;
	public final int PRINT_BOOKS = 2;

	// variable that communicate with the user
	private DataReader dataReader;

	// "library" that stores the data
	private Library library;

	public LibraryControl() {
		dataReader = new DataReader();
		library = new Library();
	}

	// main loop of the program that allows option selection and interaction
	public void controlLopp() {
		int option;
		printOptions();
		while ((option = dataReader.getInt()) != EXIT) {
			switch (option) {
			case ADD_BOOK:
				addBook();
				break;
			case PRINT_BOOKS:
				printBooks();
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
			printOptions();
		}
		// closing scanner stream
		dataReader.close();
	}

	private void printOptions() {
		System.out.println("Please select option:");
		System.out.println();
		System.out.println("0 - Exit the program");
		System.out.println("1 - Add new book");
		System.out.println("2 - Print available books");
		System.out.println();
	}

	private void addBook() {
		Book book = dataReader.readAndCreateBook();
		library.addBook(book);
	}

	private void printBooks() {
		library.printBooks();
	}

}
