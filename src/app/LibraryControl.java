package app;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import data.Book;
import data.Library;
import data.LibraryUser;
import data.Magazine;
import utils.DataReader;
import utils.FileManager;
import utils.LibraryUtils;

public class LibraryControl {

	// variable that communicate with the user
	private DataReader dataReader;
	private FileManager fileManager;

	// "library" that stores the data
	private Library library;

	public LibraryControl() {
		dataReader = new DataReader();
		fileManager = new FileManager();
		System.out.println("Reading data from file...");
		try {
			library = fileManager.readLibraryFromFile();
			System.out.println("Done");
		} catch (ClassNotFoundException | IOException e) {
			library = new Library();
			System.out.println("New database has been created.");
		}
	}

	// main loop of the program that allows option selection and interaction
	public void controlLopp() {
		Option option = null;
		while (option != Option.EXIT) {
			try {
				printOptions();
				option = Option.createFromInt(dataReader.getInt());
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
				case ADD_USER:
					addUser();
					break;
				case PRINT_USERS:
					printUsers();
					break;
				case EXIT:
					exit();
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid data - publication was not added");
			} catch (NumberFormatException | NoSuchElementException e) {
				System.out.println("Invalid option. Please try again.");
			}
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
		LibraryUtils.printBooks(library);
	}

	private void addMagazine() {
		Magazine magazine = dataReader.readAndCreateMagazine();
		library.addMagazine(magazine);
	}

	private void printMagazines() {
		LibraryUtils.printMagazines(library);
	}
	
	private void addUser() {
		LibraryUser user = dataReader.readAndCreateLibraryUser();
		library.addUser(user);
	}
	
	private void printUsers() {
		LibraryUtils.printUsers(library);
	}
	
	private void exit() {
		fileManager.writeLibraryToFile(library);
	}
	
	private enum Option {
		EXIT(0, "Exit the program"), 
		ADD_BOOK(1, "Add new book"), 
		ADD_MAGAZINE(2, "Add new magazine"), 
		PRINT_BOOKS(3, "Print available books"), 
		PRINT_MAGAZINES(4, "Print available magazines"),
		ADD_USER(5, "Add new user"),
		PRINT_USERS(6, "Print list of users");

		private int value;
		private String description;

		Option(int value, String description) {
			this.value = value;
			this.description = description;
		}

		@Override
		public String toString() {
			return value + " " + description;
		}

		public static Option createFromInt(int option) throws NoSuchElementException {
			Option result = null;
			try {
				result = Option.values()[option];
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new NoSuchElementException("Invalid element");
			}
			return result;
		}
	}
}
