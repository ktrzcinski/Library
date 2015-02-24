package utils;

import data.Book;
import data.Library;
import data.Magazine;

public class LibraryUtils {
	
	public static void printBooks(Library lib) {
		long countBooks = lib.getPublications().values().stream().filter(Book.class::isInstance)
				.sorted(new Library.AlphabeticalComparator()).peek(System.out::println).count();
		
		if(countBooks == 0) {
			System.out.println("No books in the library");
		}
	}
	
	public static void printMagazines(Library lib) {
		long countMagazines = lib.getPublications().values().stream().filter(Magazine.class::isInstance)
				.sorted(new Library.AlphabeticalComparator()).peek(System.out::println).count();
		
		if(countMagazines == 0) {
			System.out.println("No magazines in the library");
		}
	}
	
	public static void printUsers(Library lib) {
		lib.getUsers().values().stream()
				.sorted((a, b) -> a.getLastName().compareTo(b.getLastName()))
				.forEach(System.out::println);
	}
}
