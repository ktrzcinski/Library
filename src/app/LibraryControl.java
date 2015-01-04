package app;

import data.Book;
import data.Library;
import data.Magazine;
import utils.DataReader;

public class LibraryControl {

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
		Option option;
		printOptions();
		while ((option = Option.createFromInt(dataReader.getInt())) != Option.EXIT) {
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
			case EXIT:
				;
			}
			printOptions();
		}
		// closing scanner stream
		dataReader.close();
	}

	private void printOptions() {
		System.out.println("Please select option:");
		for (Option o : Option.values()) {
			System.out.println(o);
		}
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
