package data;

public class Book extends Publication {
	// variables
	private String author;
	private int pages;
	private String isbn;

	// setters & getters
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	// constructors
	public Book(String title, String author, int year, int pages,
			String publisher, String isbn) {
		super(year, title, publisher);
		this.setAuthor(author);
		this.setPages(pages);
		this.setIsbn(isbn);
	}

	public Book(Book book) {
		this(book.getTitle(), book.getAuthor(), book.getYear(), book
				.getPages(), book.getPublisher(), book.getIsbn());
	}

	public void printInfo() {
		String info = getTitle() + "; " + getAuthor() + "; " + getYear()
				+ "; " + getPages() + "; " + getPublisher() + "; " + getIsbn();
		System.out.println(info);
	}
}