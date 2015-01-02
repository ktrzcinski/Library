package app;

import data.Book;
import utils.DataReader;

public class Library {
	public static void main(String[] args) {
		final String APP_NAME = "Biblioteka v0.6";

		Book[] books = new Book[1000];
		DataReader dataReader = new DataReader();

		System.out.print(APP_NAME);
		System.out.println("Wprowad� now� ksi��k�:");
		books[0] = dataReader.readAndCreateBook();
		books[1] = dataReader.readAndCreateBook();
		dataReader.close();

		books[0].printInfo();
		books[1].printInfo();
		System.out.println("System mo�e przechowywa� do " + books.length
				+ " ksi��ek");
	}
}