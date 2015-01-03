package data;

public class Library {

	public static final int MAX_BOOKS = 1000;
	private Book[] books;
	private int booksNumber;

	public int getBooksNumber() {
		return this.booksNumber;
	}

	public Book[] getBooks() {
		return books;
	}

	public Library() {
		books = new Book[MAX_BOOKS];
	}

	public void addBook(Book book) {
		if (booksNumber < MAX_BOOKS) {
			books[booksNumber] = book;
			booksNumber++;
		} else {
			System.out.println("Max amount of books has been reached");
		}
	}

	public void printBooks() {
		if (booksNumber == 0) {
			System.out.println("No books in the library.");
		}
		for (int i = 0; i < booksNumber; i++) {
			books[i].printInfo();
		}
	}

}