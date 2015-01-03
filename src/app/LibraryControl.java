package app;

import data.Book;
import data.Library;
import data.Magazine;
import utils.DataReader;

public class LibraryControl {

	// variables do control the program
	public static final int EXIT = 0;
	public static final int ADD_BOOK = 1;
	public static final int PRINT_BOOKS = 2;
	public static final int ADD_MAGAZINE = 3;
	public static final int PRINT_MAGAZINES = 4;

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
			case ADD_MAGAZINE:
				addMagazine();
				break;
			case PRINT_BOOKS:
				printBooks();
				break;
			case PRINT_MAGAZINES:
				printMagazines();
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
		System.out.println(EXIT + " - Exit the program");
		System.out.println(ADD_BOOK + " - Add new book");
		System.out.println(ADD_MAGAZINE + " - Add new magazine");
		System.out.println(PRINT_BOOKS + " - Print available books");
		System.out.println(PRINT_MAGAZINES + " - Print available magazines");
	}

	private void addBook() {
		Book book = dataReader.readAndCreateBook();
		library.addBook(book);
	}

	private void printBooks() {
		library.printBooks();
	}

	private void addMagazine() {
		Magazine magazine = dataReader.readAndCreateMagazine();
		library.addMagazine(magazine);
	}

	private void printMagazines() {
		library.printMagazines();
	}

}
