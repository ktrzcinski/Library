package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import data.Book;
import data.LibraryUser;
import data.Magazine;

public class DataReader {
	private Scanner sc;

	public DataReader() {
		sc = new Scanner(System.in);
	}

	public void close() {
		sc.close();
	}

	public int getInt() throws NumberFormatException {
		int number = 0;
		try {
			number = sc.nextInt();
		} catch (InputMismatchException e) {
			throw new NumberFormatException("Invalid number");
		} finally {
			sc.nextLine();
		}
		return number;
	}

	public Book readAndCreateBook() throws InputMismatchException {
		System.out.println("Title: ");
		String title = sc.nextLine();
		System.out.println("Author: ");
		String author = sc.nextLine();
		System.out.println("Publisher: ");
		String publisher = sc.nextLine();
		System.out.println("ISBN: ");
		String isbn = sc.nextLine();
		System.out.println("Release date: ");
		int releaseDate = 0;
		int pages = 0;
		try {
			releaseDate = sc.nextInt();
			sc.nextLine();
			System.out.println("No of pages: ");
			pages = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw e;
		}

		return new Book(title, author, releaseDate, pages, publisher, isbn);
	}

	public Magazine readAndCreateMagazine() throws InputMismatchException {
		System.out.println("Title: ");
		String title = sc.nextLine();
		System.out.println("Publisher: ");
		String publisher = sc.nextLine();
		System.out.println("Language: ");
		String language = sc.nextLine();
		System.out.println("Year: ");
		int year = 0;
		int month = 0;
		int day = 0;
		try {
			year = sc.nextInt();
			sc.nextLine();
			System.out.println("Month: ");
			month = sc.nextInt();
			sc.nextLine();
			System.out.println("Day: ");
			day = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw e;
		}

		return new Magazine(title, publisher, language, year, month, day);
	}
	
	public LibraryUser readAndCreateLibraryUser() {
		System.out.println("First Name: ");
		String firstName = sc.nextLine();
		System.out.println("Last Name: ");
		String lastName = sc.nextLine();
		System.out.println("PPS no: ");
		String ppsNo = sc.nextLine();
		
		return new LibraryUser(firstName, lastName, ppsNo);
	}

}
